package com.zzb.water.shop.service;

import com.zzb.water.shop.domain.Item;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 16:40 2019/7/5
 */
public interface ItemService{
    /**
     * 保存
     * @param item
     * @return
     */
    Item save(Item item);

    /**
     * 根据标题查询
     * @param titel
     * @return
     */
    List<Item> findByTitle(String titel);

}
