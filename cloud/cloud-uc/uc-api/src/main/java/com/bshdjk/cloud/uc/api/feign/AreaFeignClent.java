package com.bshdjk.cloud.uc.api.feign;

import com.bshdjk.cloud.common.feign.FeignInsideAuthConfig;
import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.uc.api.vo.AreaVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "uc-user",contextId = "area")
public interface AreaFeignClent {
    /**
     * 根据areaId获取地区信息
     * @param areaId
     * @return
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/user/getAreaById")
    Result<AreaVO> getAreaById(@RequestParam("areaId") Long areaId);

}
