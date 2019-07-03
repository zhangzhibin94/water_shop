package com.zzb.water.shop.service;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author by 张志斌 .
 * @Date 11:23 2019/7/2
 */
@NacosPropertySource(dataId = "zzb_config", groupId = "db", autoRefreshed = true)
@SpringBootApplication()
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class,args);
    }
}
