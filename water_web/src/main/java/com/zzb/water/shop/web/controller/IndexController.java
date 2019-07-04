package com.zzb.water.shop.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 16:35 2019/7/1
 */
@Controller
@RequestMapping("/v1/web")
public class IndexController {
    @Reference(version = "${demo.service.version}")
    private UserService userService;
    @RequestMapping("/test")
    public String test(){
        User user = new User();
        List<User> user1 = userService.findUser(user);
        return "default.html";



    }
}
