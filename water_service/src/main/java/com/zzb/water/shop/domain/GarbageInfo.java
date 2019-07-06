package com.zzb.water.shop.domain;

import com.zzb.water.shop.core.domian.BaseDomain;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @Author by 张志斌 .
 * @Date 14:22 2019/7/6
 * 垃圾回收
 */
@Document(indexName = "commodity",type = "garbage")
public class GarbageInfo extends BaseDomain{
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    @Field(searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String name;
    /**
     * 回收步骤
     */
    private String collectionStep;
    /**
     * 描述
     */
    private String description;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 垃圾类型：1.干垃圾 2.湿垃圾 3.可回收垃圾 4.有害垃圾
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollectionStep() {
        return collectionStep;
    }

    public void setCollectionStep(String collectionStep) {
        this.collectionStep = collectionStep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
