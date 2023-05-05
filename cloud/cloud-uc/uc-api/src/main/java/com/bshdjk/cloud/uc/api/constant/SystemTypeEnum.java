package com.bshdjk.cloud.uc.api.constant;

/**
 * 系统类型
 * @author zhouxd
 * @since  2023-05-05 10:59:50
 */
public enum SystemTypeEnum {

	/**
	 * 普通用户系统
	 */
	ORDINARY(0),

	/**
	 * 医生端
	 */
	DOCTOR(1),

	/**
	 * 商家端
	 */
	MULTISHOP(2),

	/**
	 * 平台端
	 */
	PLATFORM(3),

	;

	private final Integer value;

	public Integer value() {
		return value;
	}

	SystemTypeEnum(Integer value) {
		this.value = value;
	}

}
