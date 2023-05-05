package com.bshdjk.cloud.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.demo.entity.Zoo;
import com.bshdjk.cloud.demo.request.ZooAnimalQueryRequest;
import com.bshdjk.cloud.demo.request.ZooQueryRequest;
import com.bshdjk.cloud.demo.service.ZooService;
import com.bshdjk.cloud.demo.vo.ZooAnimalVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 动物园(Zoo)表控制层
 *
 * @author zhouxd
 * @since 2023-04-24 16:30:37
 */
@RestController
@RequestMapping("zoo")
@Api(tags = "动物园")
public class ZooController {
    /**
     * 服务对象
     */
    @Resource
    private ZooService zooService;

    /**
     * 分页查询
     *
     * @param request 分页对象
     * @return 查询结果
     */
    @GetMapping
    @ApiOperation(value = "分页获取动物园列表")
    public Result<IPage<Zoo>> getList(ZooQueryRequest request) {
        Page<Zoo> page = new Page<>(request.getPageNo(),request.getPageSize());
        return Result.succ(zooService.page(page, new QueryWrapper<>()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return Zoo单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(value = "通过主键获取动物园详情")
    public Result<Zoo> getById(@PathVariable("id") Long id) {
        return Result.succ(zooService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zoo 实体
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "增加动物园详情")
    public Result<Boolean> insert(@RequestBody Zoo zoo) {
        return Result.succ(zooService.save(zoo));
    }

    /**
     * 编辑数据
     *
     * @param zoo 实体
     * @return 编辑结果
     */
    @PutMapping
    @ApiOperation(value = "编辑动物园详情")
    public Result<Boolean> update(@RequestBody Zoo zoo) {
        return Result.succ(zooService.updateById(zoo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    @ApiOperation(value = "删除动物园详情")
    public Result<Boolean> deleteById(Long id) {
        Zoo zoo = new Zoo();
        zoo.setId(id);
        zoo.setIsDeleted(1);
        zoo.setUpdater("getUserName");
        return Result.succ(zooService.updateById(zoo));
    }

    /**
     * 分页查询
     *
     * @param request 分页对象
     * @return 查询结果
     */
    @GetMapping( "getzooanimallist")
    @ApiOperation(value = "分页获取动物园和动物信息")
    public Result<IPage<ZooAnimalVO>> getZooAnimalList(ZooAnimalQueryRequest request) {
        return Result.succ(zooService.pageZooAnimal(request));
    }
}

