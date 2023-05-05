package com.bshdjk.cloud.search.constant;

/**
 * es当中的index
 * @author zhouxd
 * @date 2023-04-16 11:15:33
 */
public enum EsIndexEnum {

    /**
     * 动物园
     */
    ZOO("zoo"),


    /**
     * 订单
     */
    ORDER("order")

    ;

    private final String value;

    public String value() {
        return value;
    }

    EsIndexEnum(String value) {
        this.value = value;
    }
}
