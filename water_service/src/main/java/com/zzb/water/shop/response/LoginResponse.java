package com.zzb.water.shop.response;

import com.zzb.water.shop.core.response.BaseResponse;

/**
 * @Author by 张志斌 .
 * @Date 14:15 2019/7/23
 */
public class LoginResponse extends BaseResponse {

    /**
     * 类型
     */
    private String type = "account";
    /**
     * 登录用户名
     */
    private String currentAuthority;

    /**
     * 提示信息
     */
    private String message;

    /**
     * token
     */
    private String token;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentAuthority() {
        return currentAuthority;
    }

    public void setCurrentAuthority(String currentAuthority) {
        this.currentAuthority = currentAuthority;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
