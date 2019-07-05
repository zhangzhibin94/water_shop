package com.zzb.water.shop.repository;

import com.zzb.water.shop.domain.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 16:15 2019/7/5
 */
@Component
public interface ItemRepository extends ElasticsearchRepository<Item, Long>{
    /**
     * 根据title和content匹配，若两者都存在，则必须满足两个条件
     * @param title
     * @return
     */
    List<Item> findByTitle(String title);
}
