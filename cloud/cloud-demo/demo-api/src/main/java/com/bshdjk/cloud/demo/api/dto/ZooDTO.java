package com.bshdjk.cloud.demo.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class ZooDTO implements Serializable {
private static final long serialVersionUID = -67627682170571242L;

@ApiModelProperty(value = "动物园id")
private Long id;

@ApiModelProperty(value = "动物园名称")
private String name;

@ApiModelProperty(value = "动物园描述")
private String des;

@ApiModelProperty(value = "创建人")
private String creator;

@ApiModelProperty(value = "更新人")
private String updater;

        }
