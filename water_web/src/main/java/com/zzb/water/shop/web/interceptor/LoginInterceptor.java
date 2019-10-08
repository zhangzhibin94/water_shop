package com.zzb.water.shop.web.interceptor;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.service.UserService;
import com.zzb.water.shop.web.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张志斌
 * @date 2019/07/23
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Reference(version = "${demo.service.version}")
    private UserService userService;

    @NacosValue(value = "${domainName}", autoRefreshed = true)
    private String domainName;
    /**
     * 进入controller层之前拦截请求
     * sso拦截说明：redis中key为uuid生成的32为token，格式为user:sso:token,
     * value为user对象的json字符串
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(true){
            return true;
        }
        System.out.println("sso interceptor init");
        //从拦截器中获取cookie的信息
        String token = CookieUtils.getCookieValue(request,"token");
        //如果cookie存在token，则取redis中查看是否存在与之匹配的记录
        if(StringUtils.isNotEmpty(token)){
            //根据token获取user
            User user = userService.getUserStrByToken(token);
            //若user存在，说明此用户已经登录
            if(user != null){
                //将user信息存放在request作用域中
                request.setAttribute("user",user);
                //同时更新cookie中的过期时间
                CookieUtils.setCookie(request,response,"token",token,30*60);
                return true;
            }
        }
        //重定向到登录页面
        response.sendRedirect("http://"+domainName+"/#/user/login" );
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        HandlerInterceptor.super.postHandle(request, response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion()");
        HandlerInterceptor.super.afterCompletion(request, response,handler,ex);
    }


}
