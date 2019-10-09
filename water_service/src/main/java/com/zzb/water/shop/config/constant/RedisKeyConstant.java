package com.zzb.water.shop.config.constant;

/**
 * @Author by 张志斌 .
 * @Date 14:52 2019/7/6
 */
public class RedisKeyConstant {
    public static final String WATER_SHOP_GARBAGE_INFO_SAVE = "water:shop:garbage:info:save:%s";

    public static final String WATER_SHOP_GARBAGE_INFO_BY_NAME = "water:shop:garbage:info:name:%s";

    /**
     * token验证key
     */
    public final static String WATER_SHOP_WEB_LOGIN = "water:shop:web:login:%s";

    /**
     * 根据手机号校验验证码
     */
    public static final String WATER_SHOP_CHECK_CAPTCHA_MOBILE = "water:shop:check:captcha:mobile:%s";

    /**
     * 用户
     */
    public static final String WATER_SHOP_USER_MOBILE = "water:shop:user:%s";
    /**
     * 私有化构造方法，不允许通过new等形式创建该类，只能通过类名.方法名
     */
    private RedisKeyConstant(){
    }
}
