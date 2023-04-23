package com.bshdjk.cloud.common.response;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

/**
 * 统一返回数据
 *
 * @author zhouxd
 * @since 2023-04-17 14:00:15
 */
@Data
public class Result<T> implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(Result.class);

	/**
	 * 状态码
	 */
	private String code;

	/**
	 * 信息
	 */
	private String msg;

	/**
	 * 数据
	 */
	private T data;

	public boolean isSucc() {
		return Objects.equals(ResponseEnum.OK.value(), this.code);
	}

	@Override
	public String toString() {
		return "Result{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
	}

	public static <T> Result<T> succ(T data) {
		Result<T> result = new Result<>();
		result.setData(data);
		result.setCode(ResponseEnum.OK.value());
		return result;
	}

	public static <T> Result<T> succ() {
		Result<T> result = new Result<>();
		result.setCode(ResponseEnum.OK.value());
		result.setMsg(ResponseEnum.OK.getMsg());
		return result;
	}

	/**
	 * 前端显示失败消息
	 * @param msg 失败消息
	 * @return
	 */
	public static <T> Result<T> showFailMsg(String msg) {
		log.error(msg);
		Result<T> result = new Result<>();
		result.setMsg(msg);
		result.setCode(ResponseEnum.SHOW_FAIL.value());
		return result;
	}

	public static <T> Result<T> fail(ResponseEnum responseEnum) {
		log.error(responseEnum.toString());
		Result<T> result = new Result<>();
		result.setMsg(responseEnum.getMsg());
		result.setCode(responseEnum.value());
		return result;
	}

	public static <T> Result<T> fail(ResponseEnum responseEnum, T data) {
		log.error(responseEnum.toString());
		Result<T> result = new Result<>();
		result.setMsg(responseEnum.getMsg());
		result.setCode(responseEnum.value());
		result.setData(data);
		return result;
	}

	public static <T> Result<T> transform(Result<?> oldResult) {
		Result<T> result = new Result<>();
		result.setMsg(oldResult.getMsg());
		result.setCode(oldResult.getCode());
		log.error(result.toString());
		return result;
	}

}
