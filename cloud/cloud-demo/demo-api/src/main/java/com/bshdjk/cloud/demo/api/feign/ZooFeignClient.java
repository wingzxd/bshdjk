package com.bshdjk.cloud.demo.api.feign;

import com.bshdjk.cloud.common.feign.FeignInsideAuthConfig;
import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.demo.api.dto.ZooDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 动物园(Zoo)接口
 *
 * @author zhouxd
 * @since 2023-05-04 09:24:36
 */
@FeignClient(value = "demo",contextId = "zoo")
public interface ZooFeignClient {

    /**
     * 根据zooId获取动物园信息
     *
     * @param zooId 动物园编号
     * @return zoo
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/demo/getZooById")
    Result<ZooDTO> getZooById(@RequestParam("zooId") Long zooId);

}
