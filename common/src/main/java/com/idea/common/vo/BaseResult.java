package com.idea.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@ApiModel("通用结果集")
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 4354300170761699477L;

    @ApiModelProperty(value = "是否成功",dataType = "Boolean",position = 1)
    private Boolean success =false;

    @ApiModelProperty(value = "响应编码",dataType = "String",position = 2)
    private String code;

    @ApiModelProperty(value = "响应描述",dataType = "String",position = 3)
    private String msg;

    @ApiModelProperty(value = "错误描述",dataType = "String",position = 4)
    private String errorMsg;

    @ApiModelProperty(value = "响应结果集",dataType = "Map",position = 5)
    private Map<?,?> map;
}
