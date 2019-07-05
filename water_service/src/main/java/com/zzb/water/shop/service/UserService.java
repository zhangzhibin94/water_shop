package com.zzb.water.shop.service;

import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.request.LoginByTelephoneRequest;
import com.zzb.water.shop.response.LoginResponse;
import com.zzb.water.shop.response.RegisterCreateResponse;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 13:29 2019/7/4
 */

public interface UserService {

    List<User> findUser(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */

    RegisterCreateResponse register(User user);

    /**
     * 通过用户名密码登录
     * @param user
     * @return
     */
    LoginResponse loginByUserName(User user);

    /**
     * 通过手机号验证码登录
     * @param request
     * @return
     */
    LoginResponse loginByTelephone(LoginByTelephoneRequest request);

    /**
     * 用户是否存在（判断用户名或手机号是否已经存在）
     * @param user
     * @return
     */
    Long isExistUser(User user);
}
