package com.bshdjk.cloud.search.dto;

import com.bshdjk.cloud.common.dto.BaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 动物园 DTO
 *
 * @author zhouxd
 * @date 2023-04-07 10:15:32
 */
@Data
public class ZooDTO extends BaseDTO implements Serializable {
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
}