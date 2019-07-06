package com.zzb.water.shop.core.domian;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author by 张志斌 .
 * @Date 14:14 2019/7/6
 */
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean deleted = false;
    private Long rowVersion = 0L;
    private Date creationTime;
    private Date lastUpdateTime;
    private Long lastUpdateBy;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Long rowVersion) {
        this.rowVersion = rowVersion;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}
