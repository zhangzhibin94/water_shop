package com.zzb.water.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zzb.water.shop.common.utils.IdUtils;
import com.zzb.water.shop.config.constant.RedisKeyConstant;
import com.zzb.water.shop.domain.GarbageInfo;
import com.zzb.water.shop.mapper.GarbageInfoMapper;
import com.zzb.water.shop.repository.GarbageInfoRepository;
import com.zzb.water.shop.service.GarbageService;
import com.zzb.water.shop.utils.RedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 14:45 2019/7/6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GarbageServiceImpl implements GarbageService {
    @Autowired
    GarbageInfoMapper garbageInfoMapper;

    @Autowired
    private GarbageInfoRepository garbageInfoRepository;

    @Autowired
    private RedisClient redisClient;

    @Override
    public Integer insert(GarbageInfo garbageInfo) {
        garbageInfo.setId(IdUtils.getId());
        garbageInfo.setCreationTime(new Date());
        garbageInfo.setLastUpdateTime(new Date());
        Integer insert = garbageInfoMapper.insert(garbageInfo);
        //插入成功 同步到es中
        if(insert!=0){
            GarbageInfo result = garbageInfoRepository.save(garbageInfo);
            if(result != null){
                //同步到redis中,key为id
                String key = String.format(RedisKeyConstant.WATER_SHOP_GARBAGE_INFO_SAVE, result.getId());
                redisClient.set(key, JSONObject.toJSONString(result));
            }
        }
        return insert;
    }

    @Override
    public List<GarbageInfo> findGarbage(String name) {
        //根据名称查找
        if(StringUtils.isEmpty(name)){
            return null;
        }
        //1.去es中找
        List<GarbageInfo> entityList = garbageInfoRepository.findByName(name);
        if(!CollectionUtils.isEmpty(entityList)){
            return entityList;
        }
        //2.从数据库中取
        GarbageInfo garbageInfo = new GarbageInfo();
        garbageInfo.setName(name);
        List<GarbageInfo> garbageInfoList = garbageInfoMapper.find(garbageInfo);
        //刷新到es中
        garbageInfoList.stream().forEach(ent-> garbageInfoRepository.save(ent));
        return garbageInfoList;
    }

    @Override
    public Integer delete(GarbageInfo garbageInfo) {
        //1.删除数据库中的数据
        Integer delete = garbageInfoMapper.delete(garbageInfo);
        if(delete != 0){
            //2.删除es中的数据
            garbageInfoRepository.deleteById(garbageInfo.getId());
            //3.删除redis中的数据
            String key = String.format(RedisKeyConstant.WATER_SHOP_GARBAGE_INFO_SAVE, garbageInfo.getId());
            redisClient.delete(key);
        }
        return delete;
    }

    @Override
    public Integer update(GarbageInfo garbageInfo) {
        garbageInfo.setLastUpdateTime(new Date());
        Integer update = garbageInfoMapper.update(garbageInfo);
        if(update != 0){
            //1.删除es
            garbageInfoRepository.deleteById(garbageInfo.getId());
            //2.删除redis
            String key = String.format(RedisKeyConstant.WATER_SHOP_GARBAGE_INFO_SAVE, garbageInfo.getId());
            redisClient.delete(key);
        }
        return update;
    }
}
