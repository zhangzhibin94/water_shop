package com.zzb.water.shop.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author 张志斌
 * @date 15:27 2020/1/9
 * description 商品查询DTO
 */
public class ItemFindDTO extends PageDTO implements Serializable{
    private Integer id;
    private List<Integer> idList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
