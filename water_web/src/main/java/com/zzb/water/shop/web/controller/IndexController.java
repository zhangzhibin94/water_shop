package com.zzb.water.shop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author by 张志斌 .
 * @Date 16:35 2019/7/1
 */
@Controller
@RequestMapping("/v1/web")
public class IndexController {
    @RequestMapping("/test")
    public String test(){
        return "default.html";
    }
}
