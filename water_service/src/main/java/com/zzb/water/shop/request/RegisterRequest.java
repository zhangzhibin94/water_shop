package com.zzb.water.shop.request;

import com.zzb.water.shop.core.request.BaseRequest;

/**
 * @Author by 张志斌 .
 * @Date 11:13 2019/10/9
 */
public class RegisterRequest extends BaseRequest {
    private String captcha;
    private String password;
    private String prefix;
    private String mobile;
    private String mail;
    private String userName;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
