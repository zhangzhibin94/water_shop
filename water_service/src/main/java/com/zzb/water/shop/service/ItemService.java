package com.zzb.water.shop.service;

import com.zzb.water.shop.domain.Item;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 16:40 2019/7/5
 */
public interface ItemService{
    Item save(Item item);
    List<Item> findByTitle(String titel);

}
