package com.zzb.water.shop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import com.zzb.water.shop.common.context.PromptMessage;
import com.zzb.water.shop.common.utils.IdUtils;
import com.zzb.water.shop.common.utils.Md5Utils;
import com.zzb.water.shop.config.constant.CommonConstant;
import com.zzb.water.shop.config.constant.RedisKeyConstant;
import com.zzb.water.shop.core.config.context.CoreConstant;
import com.zzb.water.shop.core.config.context.ErrorMsg;
import com.zzb.water.shop.core.config.context.ErrorType;
import com.zzb.water.shop.core.response.BaseResponse;
import com.zzb.water.shop.core.utils.MessageUtil;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.mapper.UserMapper;
import com.zzb.water.shop.request.LoginByTelephoneRequest;
import com.zzb.water.shop.request.LoginRequest;
import com.zzb.water.shop.request.RegisterRequest;
import com.zzb.water.shop.response.LoginCheckResponse;
import com.zzb.water.shop.response.LoginResponse;
import com.zzb.water.shop.response.RegisterCreateResponse;
import com.zzb.water.shop.service.UserService;
import com.zzb.water.shop.utils.RedisClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author zzb
 * 用户服务
 */
@Service(version = "${demo.service.version}")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private MessageUtil messageUtil;

    /**
     * 用户注册
     * @param request
     * @return
     */
    @Override
    public RegisterCreateResponse register(RegisterRequest request) {
        RegisterCreateResponse response = new RegisterCreateResponse();
        if(StringUtils.isEmpty(request.getCaptcha()) || StringUtils.isEmpty(request.getMobile())
                || StringUtils.isEmpty(request.getPassword())){
            response.addError(CoreConstant.ERROR, CoreConstant.PARAM_ERROR);
            return response;
        }
        if(StringUtils.isEmpty(request.getUserName())){
            request.setUserName(request.getMobile());
        }
        //获取redis中的验证码
        User user = new User();
        BeanUtils.copyProperties(request, user);
        user.setEmail(request.getMail());
        user.setPhone(Long.parseLong(request.getMobile()));
        //校验验证码
        LoginCheckResponse loginCheckResponse = this.checkCode(user, request.getCaptcha());
        if(loginCheckResponse.hasError()){
            response.addErrors(CoreConstant.ERROR, loginCheckResponse.getErrors());
            return response;
        }
        //密码进行md5加密
        user.setPassword(Md5Utils.encryption(user.getPassword()));
        user.setId(IdUtils.getId());
        long insert = userMapper.insert(user);
        if(insert>0){
            response.setUser(user);
        }else {
            response.addError(ErrorType.BUSINESS_ERROR,"插入失败，请刷新页面后重试");
            return response;
        }
        return response;
    }
    /**
     * 通过用户名密码登录
     * @param user
     * @return
     */
    @Override
    public LoginCheckResponse loginByUserName(User user) {
        LoginCheckResponse response = new LoginCheckResponse();
        //用户名或密码为空
        if(StringUtils.isEmpty(user.getUserName())|| StringUtils.isEmpty(user.getPassword())){
            response.addError(ErrorType.EXPECTATION_NULL,"用户名或密码不能为空，请检查");
            return response;
        }else{
            //密码需经过md5加密
            user.setPassword(Md5Utils.encryption(user.getPassword()));
            user= userMapper.loginByUserName(user);
            if(user==null){
                response.addError(ErrorType.BUSINESS_ERROR,"用户名或密码错误！");
                return response;
            }
        }
        response.setUser(user);
        return response;
    }
    /**
     * 通过手机号验证码登录
     * @param request
     * @return
     */
    @Override
    public LoginCheckResponse loginByTelephone(LoginByTelephoneRequest request) {
        LoginCheckResponse response = new LoginCheckResponse();
        if(request.getTelephone() == null || StringUtils.isEmpty(request.getCode())){
            response.addError(ErrorType.BUSINESS_ERROR, ErrorMsg.PARAM_ERROR);
            return response;
        }
        User user = new User();
        user.setPhone(request.getTelephone());
        LoginCheckResponse loginCheckResponse = this.checkCode(user, request.getCode());
        if(loginCheckResponse.hasError()){
            response.addErrors(CoreConstant.ERROR, loginCheckResponse.getErrors());
            return response;
        }
        //校验通过手机号和验证码通过h
        //根据手机号查询用户信息
        User loginUser = userMapper.loginByTelephone(user);
        response.setUser(loginUser);

        return response;
    }

    @Override
    public Long isExistUser(User user) {
        if(StringUtils.isNotEmpty(user.getUserName())||user.getPhone()!=null){
            Long result = userMapper.isExistUser(user);
            return result;
        }else {
            return 0L;
        }
    }

    @Override
    public User getUserStrByToken(String token) {
        if(StringUtils.isNotEmpty(token)){
            String key = String.format(RedisKeyConstant.WATER_SHOP_WEB_LOGIN, token);
            String userStr = redisClient.get(key);
            //若redis同样存在该记录，说明此用户已经登录
            if(StringUtils.isNotEmpty(userStr)){
                //刷新redis中的key的过期时间
                redisClient.expire("user:sso:" + token,30, TimeUnit.MINUTES);
                //将此json串转为user对象
               return JSON.parseObject(userStr, User.class);
            }
        }
        return null;
    }

    @Override
    public BaseResponse sendMessage(String telephone) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            String msg = messageUtil.sendMessage(telephone);
            //将验证码md5加密
            String md5Message = DigestUtils.md5DigestAsHex(msg.getBytes());
            //3.在redis中生成一条记录，key为前缀+手机号，value为验证码
            String key = String.format(RedisKeyConstant.WATER_SHOP_CHECK_CAPTCHA_MOBILE, telephone);
            redisClient.set(key, md5Message);
            //todo 4.设置key的过期时间为15分钟,开发时设置为一小时
            redisClient.expire(key,60, TimeUnit.MINUTES);
            baseResponse.setStatus(StringUtils.isNotEmpty(msg) ? CoreConstant.OK : CoreConstant.ERROR);
        } catch (ClientException e) {
            LOGGER.error("发送短信失败："+e.getErrMsg());
            e.printStackTrace();
        }
        return baseResponse;
    }

    /**
     * 登录认证
     * @param request
     * @return
     */
    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.setType(request.getType());
        User user = new User();
        BeanUtils.copyProperties(request, user);
        //登录类型为账号密码
        if(CommonConstant.ACCOUNT_TYPE.equals(request.getType())){
            LoginCheckResponse loginCheckResponse = loginByUserName(user);
            //账号密码登录成功
            if(!loginCheckResponse.hasError() && loginCheckResponse.getUser() != null){
                response.setCurrentAuthority(user.getUserName());
                return response;
            }
        }
        //登录类型为手机验证码
        if(CommonConstant.MOBILE_TYPE.equals(request.getType())){
            LoginByTelephoneRequest telephoneRequest = new LoginByTelephoneRequest();
            telephoneRequest.setTelephone(request.getMobile());
            telephoneRequest.setCode(request.getCaptcha());
            //手机号 验证码登录
            LoginCheckResponse loginCheckResponse = loginByTelephone(telephoneRequest);
            if(loginCheckResponse.hasError() && loginCheckResponse.getStatus().equals(PromptMessage.OK)){
                response.setCurrentAuthority(user.getUserName());
                return response;
            }
        }
        //返回登录失败
        response.setStatus(CommonConstant.ERROR);
        return response;
    }

    /**
     * 校验验证码
     * @param code 验证码
     * @param user 用户
     * @return
     */
    public LoginCheckResponse checkCode(User user, String code){
        LoginCheckResponse response = new LoginCheckResponse();
        //校验参数
        if(StringUtils.isEmpty(code) || user == null){
            response.addError(PromptMessage.FAILURE, PromptMessage.INVALID_PARAMETER_MESSAGE);
            return response;
        }
        //从redis取验证码
        String key = String.format(RedisKeyConstant.WATER_SHOP_CHECK_CAPTCHA_MOBILE, user.getPhone());
        String captcha = redisClient.get(key);
        //匹配用户输入的验证码与redis中的验证码是否相同
        if(StringUtils.isNotEmpty(captcha)){
            if(StringUtils.isNotEmpty(code)){
                //将用户的验证码加密后与redis中的加密验证码进行匹配，匹配成功，则在数据库中插入用户信息
                if(captcha.equalsIgnoreCase(Md5Utils.encryption(code))){
                    response.setUser(user);
                }else {//匹配失败
                    response.addError(ErrorType.BUSINESS_ERROR,"您输入的验证码错误，请检查");
                    return response;
                }
            }else {
                response.addError(CoreConstant.ERROR,"请输入验证码");
                return response;
            }
        }else {
            response.addError(CoreConstant.ERROR,"抱歉，验证码校验失败");
            return response;
        }
        return response;
    }
}
