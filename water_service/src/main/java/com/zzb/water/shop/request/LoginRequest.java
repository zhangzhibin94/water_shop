package com.zzb.water.shop.request;

import com.zzb.water.shop.core.request.BaseRequest;

/**
 * @Author by 张志斌 .
 * @Date 14:21 2019/7/23
 */
public class LoginRequest extends BaseRequest {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 登录类型
     */
    private String type;

    /**
     * 手机号
     */
    private Long mobile;

    /**
     * 验证码
     */
    private String captcha;

    /**
     * token
     */
    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
