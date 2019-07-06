package com.zzb.water.shop.mapper;

import com.zzb.water.shop.domain.GarbageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张志斌
 */
public interface GarbageInfoMapper {
    /**
     * 添加用户
     * @param garbageInfo
     * @return
     */
    Integer insert(@Param("request") GarbageInfo garbageInfo);

    /**
     * 查询用户
     * @param garbageInfo
     * @return
     */
    List<GarbageInfo> find(@Param("request") GarbageInfo garbageInfo);

    /**
     * 删除用户
     * @param garbageInfo
     * @return
     */
    Integer delete(@Param("request") GarbageInfo garbageInfo);

    Integer update(@Param("request") GarbageInfo garbageInfo);
}
