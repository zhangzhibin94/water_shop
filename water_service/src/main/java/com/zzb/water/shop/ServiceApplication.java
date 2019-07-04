package com.zzb.water.shop;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author by 张志斌 .
 * @Date 11:23 2019/7/2
 */
@NacosPropertySource(dataId = "zzb_config", groupId = "db", autoRefreshed = true)

@ComponentScan(basePackages = {"com.zzb.water.shop.*"})
@SpringBootApplication()
@MapperScan("com.zzb.water.shop.mapper")
@EnableDubbo(scanBasePackages = "com.zzb.water.shop.service")
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class,args);
    }
}
