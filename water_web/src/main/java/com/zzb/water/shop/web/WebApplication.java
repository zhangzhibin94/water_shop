package com.zzb.water.shop.web;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @Author by 张志斌 .
 * @Date 11:44 2019/7/1
 */
@NacosPropertySource(dataId = "zzb_config", groupId = "common", autoRefreshed = true)
@SpringBootApplication()
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
