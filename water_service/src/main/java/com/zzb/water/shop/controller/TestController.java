package com.zzb.water.shop.controller;

import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 15:43 2019/7/4
 */
@Controller
public class TestController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(){
        User user = new User();
        List<User> user1 = userService.findUser(user);
        return user1;
    }
}
