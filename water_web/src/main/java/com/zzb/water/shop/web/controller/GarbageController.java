package com.zzb.water.shop.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zzb.water.shop.domain.GarbageInfo;
import com.zzb.water.shop.service.GarbageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 15:52 2019/7/6
 */
@RestController
@RequestMapping(value = "/water/shop/garbage")
public class GarbageController {

    @Reference(version = "${demo.service.version}")
    private GarbageService garbageService;

    /**
     * 添加垃圾
     * @param garbageInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insert(GarbageInfo garbageInfo){
        return garbageService.insert(garbageInfo);
    }

    /**
     * 根据名称查询垃圾
     * @param name
     * @return
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public List<GarbageInfo> findByName(String name){
        return garbageService.findGarbage(name);
    }

    /**
     * 更新垃圾
     * @param garbageInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Integer update(GarbageInfo garbageInfo){
        return garbageService.update(garbageInfo);
    }

    /**
     * 删除垃圾
     * @param garbageInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Integer delete(GarbageInfo garbageInfo){
        return garbageService.delete(garbageInfo);
    }
}
