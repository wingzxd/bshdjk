package com.bshdjk.cloud.search.vo;


import com.bshdjk.cloud.common.vo.BaseVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 动物园VO
 *
 * @author zhouxd
 * @date 2023-04-07 11:15:44
 */
@Data
public class ZooVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 685027952102898426L;
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