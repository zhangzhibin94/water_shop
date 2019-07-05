package com.zzb.water.shop.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @Author by 张志斌 .
 * @Date 11:44 2019/7/1
 */
@NacosPropertySource(dataId = "zzb_config", groupId = "common", autoRefreshed = true)
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableDubbo
public class WebApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(WebApplication.class,args);
    }
}
