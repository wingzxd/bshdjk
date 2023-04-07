package com.bshdjk.cloud.uc.api.feign;

import com.bshdjk.cloud.common.constant.Auth;
import com.bshdjk.cloud.common.response.ServerResponseEntity;
import com.bshdjk.cloud.uc.api.bo.UserInfoInTokenBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author FrozenWatermelon
 * @date 2020/7/15
 */
@FeignClient(value = "mallbshdjk-auth",contextId ="token")
public interface TokenFeignClient {

	/**
	 * 校验token并返回token保存的用户信息
	 * @param accessToken accessToken
	 * @return token保存的用户信息
	 */
	@GetMapping(value = Auth.CHECK_TOKEN_URI)
	ServerResponseEntity<UserInfoInTokenBO> checkToken(@RequestParam("accessToken") String accessToken);

}
