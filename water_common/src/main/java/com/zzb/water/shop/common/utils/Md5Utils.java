package com.zzb.water.shop.common.utils;

import java.io.UnsupportedEncodingException;

/**
 * MD5 generator
 *
 * @author 张志斌
 */
public class Md5Utils {

    private static final int HEX_VALUE_COUNT = 16;
    /**
     * 前加盐
     */
    private static final String PRE_FIX = "#ag4sfa223*N5q23!#";

    public static String getMD5(byte[] bytes) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] str = new char[16 * 2];
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte tmp[] = md.digest();
            int k = 0;
            for (int i = 0; i < HEX_VALUE_COUNT; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(str);
    }

    public static String getMD5(String value, String encode) {
        String result = "";
        try {
            result = getMD5(value.getBytes(encode));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 加盐方式对数据进行md5加密
     * @param value
     * @return
     */
    public static String encryption(String value){
        return getMD5(PRE_FIX + value, "utf-8");
    }
}
