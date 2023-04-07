package com.bshdjk.cloud.epp.demo.controller;

import com.bshdjk.cloud.epp.demo.entity.Zoo;
import com.bshdjk.cloud.epp.demo.service.ZooService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Zoo)表控制层
 *
 * @author makejava
 * @since 2023-04-07 11:13:29
 */
@RestController
@RequestMapping("zoo")
public class ZooController {
    /**
     * 服务对象
     */
    @Resource
    private ZooService zooService;

    /**
     * 分页查询
     *
     * @param zoo         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Zoo>> queryByPage(Zoo zoo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.zooService.queryByPage(zoo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Zoo> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.zooService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param zoo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Zoo> add(Zoo zoo) {
        return ResponseEntity.ok(this.zooService.insert(zoo));
    }

    /**
     * 编辑数据
     *
     * @param zoo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Zoo> edit(Zoo zoo) {
        return ResponseEntity.ok(this.zooService.update(zoo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.zooService.deleteById(id));
    }

}

