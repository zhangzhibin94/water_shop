package com.zzb.water.shop.service;

import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.request.LoginByTelephoneRequest;
import com.zzb.water.shop.request.LoginRequest;
import com.zzb.water.shop.response.LoginCheckResponse;
import com.zzb.water.shop.response.LoginResponse;
import com.zzb.water.shop.response.RegisterCreateResponse;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 13:29 2019/7/4
 */

public interface UserService {

    /**
     * 登录认证
     * @param request 认证信息，
     * @return
     */
    LoginResponse login(LoginRequest request);



    /**
     * 用户注册
     * @param user 用户
     * @param code 验证码
     * @return
     */

    RegisterCreateResponse register(User user, String code);

    /**
     * 通过用户名密码登录
     * @param user
     * @return
     */
    LoginCheckResponse loginByUserName(User user);

    /**
     * 通过手机号验证码登录
     * @param request
     * @return
     */
    LoginCheckResponse loginByTelephone(LoginByTelephoneRequest request);

    /**
     * 用户是否存在（判断用户名或手机号是否已经存在）
     * @param user
     * @return
     */
    Long isExistUser(User user);

    /**
     * 通过token获取user
     * @param token
     * @return
     */
    User getUserStrByToken(String token);


}
