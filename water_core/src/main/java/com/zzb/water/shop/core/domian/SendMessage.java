package com.zzb.water.shop.core.domian;

/**
 * @Author zzb
 * @Date 2019/10/09
 */
public class SendMessage {

    private String telephone;
    /**
     * 验证码
     */
    private String code;

    /**
     * 类型，register
     */
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
