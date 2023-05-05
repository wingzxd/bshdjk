package com.bshdjk.cloud.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bshdjk.cloud.demo.entity.Zoo;
import com.bshdjk.cloud.demo.request.ZooAnimalQueryRequest;
import com.bshdjk.cloud.demo.vo.ZooAnimalVO;
import org.apache.ibatis.annotations.Param;

/**
 * 动物园(Zoo)表数据库访问层
 *
 * @author zhouxd
 * @since 2023-04-24 16:30:36
 */
public interface ZooMapper extends BaseMapper<Zoo> {
    IPage<ZooAnimalVO> pageZooAnimal(Page<ZooAnimalVO> page, @Param("query") ZooAnimalQueryRequest request);
}

