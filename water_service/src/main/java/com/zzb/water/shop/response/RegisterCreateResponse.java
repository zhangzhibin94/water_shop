package com.zzb.water.shop.response;/**
 * Created by zzb on 2018/12/11.
 */


import com.zzb.water.shop.domain.User;

/**
 * @author zzb
 * @create 2018-12-11 11:23
 * @desc 用户注册响应
 **/
public class RegisterCreateResponse extends BaseResponse {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
