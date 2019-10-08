package com.zzb.water.shop.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.request.LoginByTelephoneRequest;
import com.zzb.water.shop.response.LoginCheckResponse;
import com.zzb.water.shop.web.config.constant.CommonConstant;
import com.zzb.water.shop.service.UserService;
import com.zzb.water.shop.request.LoginRequest;
import com.zzb.water.shop.response.LoginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author by 张志斌 .
 * @Date 16:35 2019/7/1
 */
@Controller
/*@RequestMapping("/api/login")*/
public class LoginController {
    @Reference(version = "${demo.service.version}")
    private UserService userService;

    /**
     * 登录认证
     * @param request
     * @param servletRequest
     * @return
     */
    @PostMapping("/account")
    public LoginResponse login(@RequestBody LoginRequest request, HttpServletRequest servletRequest){
        LoginResponse response = new LoginResponse();
        //如果servlet中包含用户信息，说明已经登录，直接返回即可
        if(servletRequest.getAttribute(CommonConstant.REQUEST_USER) != null){
            User user = (User)servletRequest.getAttribute("user");
            response.setCurrentAuthority(user.getUserName());
            return response;
        }

        return userService.login(request);

    }

    /**
     * 配置url通配符，拦截多个地址
     * @return
     */
    @RequestMapping(value = {
            "/",
            "/user",
            "/user/**",
            "/console",
            "/console/**"
    })
    public String fowardIndex() {
        return "index";
    }

}
