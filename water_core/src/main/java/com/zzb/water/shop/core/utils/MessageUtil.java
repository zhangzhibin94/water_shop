package com.zzb.water.shop.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.zzb.water.shop.core.config.MessageConfig;
import com.zzb.water.shop.core.config.context.CoreConstant;
import com.zzb.water.shop.core.domian.SendMessage;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author by 张志斌 .
 * @Date 9:15 2019/10/9
 */
@Component
public class MessageUtil {
    private final static String REGION_ID = "cn-hangzhou";
    private final static String ENDPOINT_NAME = "cn-hangzhou";
    private final static String SIGN_NAME = "服务器BOS";

    @Autowired
    private MessageConfig messageConfig;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MessageUtil.class);

    /** 发送短信*/
    public String sendMessage(String telephone) throws ClientException {
        LOGGER.info("------阿里云发送短信开始--------"+telephone);
        String product =messageConfig.getProduct();
        String domain =messageConfig.getDomain();
        String accessKeyId=messageConfig.getAccessKeyId();
        String accessKeySecret=messageConfig.getAccessKeySecret();

        String templateCode=messageConfig.getTemplateCode();

        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile(REGION_ID, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(ENDPOINT_NAME, REGION_ID, product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
        request.setPhoneNumbers(telephone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SIGN_NAME);
        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        SendMessage sendMessage = new SendMessage();
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        sendMessage.setCode(result);
        String param = JSONObject.toJSONString(sendMessage);
        request.setTemplateParam(param);
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        //请求成功
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals(CoreConstant.OK)) {
            return result;
        }
        return null;
    }
}
