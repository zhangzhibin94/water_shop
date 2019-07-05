package com.zzb.water.shop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzb.water.shop.domain.Item;
import com.zzb.water.shop.repository.ItemRepository;
import com.zzb.water.shop.service.ItemService;
import com.zzb.water.shop.utils.JedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 16:41 2019/7/5
 */
@Service(version = "${demo.service.version}")
@Transactional(rollbackFor = Exception.class)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private JedisClient jedisClient;
    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findByTitle(String title) {
        String key = String.format("water:shop:item:%s", title);
        String value = jedisClient.get(key);
        if(StringUtils.isNotEmpty(value)){
            return JSON.parseArray(value, Item.class);
        }
        List<Item> byTitle = itemRepository.findByTitle(title);
        jedisClient.set(key, JSONObject.toJSONString(byTitle));
        return byTitle;
    }
}
