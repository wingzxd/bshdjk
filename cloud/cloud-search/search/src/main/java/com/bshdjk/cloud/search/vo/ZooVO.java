package com.bshdjk.cloud.search.vo;


import com.bshdjk.cloud.common.vo.BaseVO;
import lombok.Data;

/**
 * 动物园VO
 *
 * @author zhouxd
 * @date 2023-04-07 11:15:44
 */
@Data
public class ZooVO extends BaseVO {

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
	 * 是否删除
	 */
	private Long isDeleted;

}