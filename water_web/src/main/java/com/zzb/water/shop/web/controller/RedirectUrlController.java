package com.zzb.water.shop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author by 张志斌 .
 * @Date 18:21 2019/10/8
 */
@Controller
public class RedirectUrlController {
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
