package com.bshdjk.cloud.common.security.bo;

import com.bshdjk.cloud.uc.api.bo.UserInfoInTokenBO;
import lombok.Data;

/**
 * token信息，该信息存在redis中
 *
 * @author FrozenWatermelon
 * @since 2020/7/2
 */
@Data
public class TokenInfoBO {

	/**
	 * 保存在token信息里面的用户信息
	 */
	private UserInfoInTokenBO userInfoInToken;

	private String accessToken;

	private String refreshToken;

	/**
	 * 在多少秒后过期
	 */
	private Integer expiresIn;
	
}
