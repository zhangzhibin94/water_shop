package com.zzb.water.shop.common.utils;

import java.util.UUID;

/**
 * @author 张志斌
 */
public class UuidUtils {

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
