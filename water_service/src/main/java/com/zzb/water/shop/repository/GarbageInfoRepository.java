package com.zzb.water.shop.repository;

import com.zzb.water.shop.domain.GarbageInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 14:25 2019/7/6
 */
@Component
public interface GarbageInfoRepository extends ElasticsearchRepository<GarbageInfo, Long>{
    List<GarbageInfo> findByName(String name);
}
