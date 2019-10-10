package com.zzb.water.shop.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zzb.water.shop.core.response.BaseResponse;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.response.UserGetResponse;
import com.zzb.water.shop.service.UserService;
import com.zzb.water.shop.web.utils.CookieUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author by 张志斌 .
 * @Date 17:51 2019/10/9
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Reference(version = "${demo.service.version}")
    private UserService userService;

    @GetMapping(value = "/currentUser")
    public UserGetResponse getUser(HttpServletRequest request){
        return userService.getUser( CookieUtils.getCookieValue(request, "token"));
    }
}
