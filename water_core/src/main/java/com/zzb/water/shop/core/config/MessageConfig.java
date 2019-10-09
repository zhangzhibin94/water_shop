package com.zzb.water.shop.core.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author by 张志斌 .
 * @Date 9:26 2019/10/9
 */
@Component
@Configuration
@NacosPropertySource(dataId = "zzb_config", groupId = "common", autoRefreshed = true)
public class MessageConfig {
    /**
     * 你的accessKeyId
     */
    @NacosValue(value = "${aliyun.message.product}", autoRefreshed = true)
    private  String product  ;
    @NacosValue("${aliyun.message.domian}")
    private  String domain  ;
    //替换成你的AK
    @NacosValue("${oss.keyid}")
    /**
     * 你的accessKeyId
     */
    private  String accessKeyId  ;
    @NacosValue("${oss.keysecret}")
    private  String accessKeySecret ;
    @NacosValue("${aliyun.message.signName}")
    private String signName;
    @NacosValue("${aliyun.message.templateName}")
    private String templateCode;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }
}
