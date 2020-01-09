package com.zzb.water.shop.dto;

import java.io.Serializable;

/**
 * @author 张志斌
 * @date 15:35 2020/1/9
 * @description
 */
public class PageDTO implements Serializable {
    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
