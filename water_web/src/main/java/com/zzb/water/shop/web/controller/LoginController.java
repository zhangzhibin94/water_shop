package com.zzb.water.shop.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zzb.water.shop.core.response.BaseResponse;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.request.LoginByTelephoneRequest;
import com.zzb.water.shop.response.LoginCheckResponse;
import com.zzb.water.shop.web.config.constant.CommonConstant;
import com.zzb.water.shop.service.UserService;
import com.zzb.water.shop.request.LoginRequest;
import com.zzb.water.shop.response.LoginResponse;
import com.zzb.water.shop.web.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author by 张志斌 .
 * @Date 16:35 2019/7/1
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Reference(version = "${demo.service.version}", check = false)
    private UserService userService;

    /**
     * 登录认证
     * @param request
     * @param servletRequest
     * @return
     */
    @PostMapping("/account")
    public LoginResponse login(@RequestBody LoginRequest request, HttpServletRequest servletRequest,
                               HttpServletResponse servletResponse){
        LoginResponse response = new LoginResponse();
        //如果servlet中包含用户信息，说明已经登录，直接返回即可
        if(servletRequest.getAttribute(CommonConstant.REQUEST_USER) != null){
            User user = (User)servletRequest.getAttribute("user");
            response.setCurrentAuthority(user.getUserName());
            return response;
        }
        LoginResponse loginResponse = userService.login(request);
        //生成一个类型为uuid的token存放到cookie中,并设置cookie的过期时间为30分钟
        if(StringUtils.isNotEmpty(loginResponse.getToken())){
            CookieUtils.setCookie(servletRequest, servletResponse,"token",loginResponse.getToken(),30*60);
        }
        return loginResponse;

    }

    /**
     * 发送短信
     * @param mobile
     * @return
     */
    @GetMapping("/captcha")
    public BaseResponse sendMessage(String mobile){
        return userService.sendMessage(mobile);
    }

}
