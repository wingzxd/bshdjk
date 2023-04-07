package com.bshdjk.cloud.epp.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Zoo)实体类
 *
 * @author makejava
 * @since 2023-04-07 11:13:42
 */
public class Zoo implements Serializable {
    private static final long serialVersionUID = 167718939950786384L;
    /**
     * 动物园id
     */
    private Long zooId;
    /**
     * 动物园名称
     */
    private String name;
    /**
     * 动物园描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态(0 正常 1 删除)
     */
    private Integer status;


    public Long getZooId() {
        return zooId;
    }

    public void setZooId(Long zooId) {
        this.zooId = zooId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

