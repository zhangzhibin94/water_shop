package com.zzb.water.shop.service;

import com.zzb.water.shop.domain.GarbageInfo;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 14:44 2019/7/6
 */
public interface GarbageService {
    /**
     * 插入
     * @param garbageInfo
     * @return
     */
    Integer insert(GarbageInfo garbageInfo);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<GarbageInfo> findGarbage(String name);

    /**
     * 删除
     * @param garbageInfo
     * @return
     */
    Integer delete(GarbageInfo garbageInfo);

    /**
     * 更新
     * @param garbageInfo
     * @return
     */
    Integer update(GarbageInfo garbageInfo);
}
