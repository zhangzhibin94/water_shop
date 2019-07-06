package com.zzb.water.shop.config.constant;

/**
 * @Author by 张志斌 .
 * @Date 14:52 2019/7/6
 */
public class RedisKeyConstant {
    public static final String WATER_SHOP_GARBAGE_INFO_SAVE = "water:shop:garbage:info:save:%s";

    public static final String WATER_SHOP_GARBAGE_INFO_BY_NAME = "water:shop:garbage:info:name:%s";
    /**
     * 私有化构造方法，不允许通过new等形式创建该类，只能通过类名.方法名
     */
    private RedisKeyConstant(){
    }
}
