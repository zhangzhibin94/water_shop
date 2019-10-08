package com.zzb.water.shop.domain;

import com.zzb.water.shop.core.domian.BaseDomain;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

/**
 * @Author by 张志斌 .
 * @Date 16:09 2019/7/5
 */
@Document(indexName = "commodity",type = "item")
public class Item extends BaseDomain {
    private Long id;
    @Field(searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String title;
    @Field(searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String description;
    private String summary;
    private Date createTime;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
