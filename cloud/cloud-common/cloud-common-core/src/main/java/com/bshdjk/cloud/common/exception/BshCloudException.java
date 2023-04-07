package com.bshdjk.cloud.common.exception;

import com.bshdjk.cloud.common.response.ResponseEnum;

/**
 * @author FrozenWatermelon
 * @date 2020/7/11
 */
public class BshCloudException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Object object;

	private ResponseEnum responseEnum;

	public BshCloudException(String msg) {
		super(msg);
	}

	public BshCloudException(String msg, Object object) {
		super(msg);
		this.object = object;
	}

	public BshCloudException(String msg, Throwable cause) {
		super(msg, cause);
	}


	public BshCloudException(ResponseEnum responseEnum) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
	}

	public BshCloudException(ResponseEnum responseEnum, Object object) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
		this.object = object;
	}


	public Object getObject() {
		return object;
	}

	public ResponseEnum getResponseEnum() {
		return responseEnum;
	}

}
