package com.bshdjk.cloud.demo.feign;

import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.demo.api.dto.ZooDTO;
import com.bshdjk.cloud.demo.api.feign.ZooFeignClient;
import com.bshdjk.cloud.demo.entity.Zoo;
import com.bshdjk.cloud.demo.service.ZooService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 动物园(Zoo)服务
 *
 * @author zhouxd
 * @since 2023-04-17 14:00:16
 */
@RestController
public class ZooFeignController implements ZooFeignClient {

    @Resource
    private ZooService zooService;

    @Resource
    private MapperFacade mapperFacade;

    @Override
    public Result<ZooDTO> getZooById(Long zooId) {
        Zoo zoo = zooService.getById(zooId);
        if (Objects.nonNull(zoo)) {
            return Result.succ(mapperFacade.map(zoo,ZooDTO.class));
        }
        return null;
    }

}
