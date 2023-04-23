package com.bshdjk.cloud.search.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 动物园 DTO
 *
 * @author zhouxd
 * @date 2023-04-07 10:15:32
 */
@Data
public class ZooDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	/**
	 * 动物园id
	 */
	private Long zooId;
	/**
	 * 动物园名称
	 */
	private String zooName;
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
	 * 是否删除
	 */
	private Long isDeleted;
}