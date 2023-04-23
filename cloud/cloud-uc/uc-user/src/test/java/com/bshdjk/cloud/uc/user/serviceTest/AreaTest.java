package com.bshdjk.cloud.uc.user.serviceTest;

import cn.hutool.core.date.DateTime;
import com.bshdjk.cloud.uc.user.model.Area;
import com.bshdjk.cloud.uc.user.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaTest extends BaseTest{

    @Autowired
    private AreaService areaService;

    @Test
    public void areaSave(){
        Area area = new Area();
        area.setAreaName("测试城市");
        area.setLevel(3);
        area.setParentId(1L);
        area.setCreateTime(DateTime.now());
        area.setUpdateTime(DateTime.now());
        areaService.save(area);
        System.out.println("-----ok-------");
    }

}
