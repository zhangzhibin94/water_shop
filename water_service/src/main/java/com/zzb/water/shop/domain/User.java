package com.zzb.water.shop.domain;

import com.zzb.water.shop.core.domian.BaseDomain;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author 张志斌
 * @date 2019/7/6
 * 用户
 */
public class User extends BaseDomain {
    @Field(searchAnalyzer = "ik_smart")
    private Long id;
    private String name;
    private String password;
    private String email;
    private String userName;
    private Long phone;
    /**
     * 用户注册用的手机
     */
    private Long telephone;

    /**
     * 验证码
     */
    private String code;

    /**
     * 登录类型
     */
    private String loginType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
