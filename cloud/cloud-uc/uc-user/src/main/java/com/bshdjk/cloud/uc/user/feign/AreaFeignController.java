package com.bshdjk.cloud.uc.user.feign;

import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.uc.api.feign.AreaFeignClent;
import com.bshdjk.cloud.uc.api.vo.AreaVO;
import com.bshdjk.cloud.uc.user.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 地区feign连接
 * @author zhouxd
 * @date 2023/04/10
 */
@RestController
public class AreaFeignController implements AreaFeignClent {

    @Autowired
    private AreaService areaService;

    @Override
    public Result<AreaVO> getAreaById(Long areaId) {
        return Result.succ(areaService.getByAreaId(areaId));
    }
}
