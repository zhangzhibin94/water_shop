package com.zzb.water.shop.common.base;

import java.io.Serializable;

/**
 * @Author by 张志斌 .
 * @Date 14:02 2019/7/23
 */
public class Result implements Serializable{
    private String status;
    private String type;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
