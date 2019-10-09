package com.zzb.water.shop.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zzb.water.shop.core.response.BaseResponse;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.request.RegisterRequest;
import com.zzb.water.shop.response.RegisterCreateResponse;
import com.zzb.water.shop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author by 张志斌 .
 * @Date 11:10 2019/10/9
 */
@RestController
@RequestMapping(value = "/api")
public class RegisterController {
    @Reference(version = "${demo.service.version}")
    private UserService userService;

    @PostMapping(value = "/register")
    public RegisterCreateResponse register(@RequestBody RegisterRequest request){
        return userService.register(request);
    }
}
