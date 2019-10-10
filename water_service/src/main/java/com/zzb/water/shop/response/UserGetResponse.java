package com.zzb.water.shop.response;

import com.zzb.water.shop.core.response.BaseResponse;

/**
 * @Author by 张志斌 .
 * @Date 17:53 2019/10/9
 */
public class UserGetResponse extends BaseResponse {
    private String avatar;
    private String email;
    private String name;
    private Integer unreadCount;
    private Long userid;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
