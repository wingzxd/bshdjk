package com.bshdjk.cloud.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * page基类
 *
 * @author zhouxd
 * @since 2023-04-15 13:21:01
 */
@Data
public class BasePage {

    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE_NO = 1;

    /**
     * 默认每页显示的记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 页码
     */
    @ApiModelProperty("页码")
    private int pageNo;

    /**
     * 每页大小
     */
    @ApiModelProperty("每页大小")
    private int pageSize;

    public BasePage() {
        this.pageNo = DEFAULT_PAGE_NO;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }
}

