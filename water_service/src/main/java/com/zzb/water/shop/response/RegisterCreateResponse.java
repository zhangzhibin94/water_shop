package com.zzb.water.shop.response;/**
 * Created by zzb on 2018/12/11.
 */


import com.zzb.water.shop.core.response.BaseResponse;
import com.zzb.water.shop.domain.User;

/**
 * @author zzb
 * @create 2018-12-11 11:23
 * @desc 用户注册响应
 **/
public class RegisterCreateResponse extends BaseResponse {
    private User user;
    private String currentAuthority = "user";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCurrentAuthority() {
        return currentAuthority;
    }

    public void setCurrentAuthority(String currentAuthority) {
        this.currentAuthority = currentAuthority;
    }
}
