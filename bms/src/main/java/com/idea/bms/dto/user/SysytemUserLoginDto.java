package com.idea.bms.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统用户登录请求参数")
@Data
public class SysytemUserLoginDto implements Serializable {
    private static final long serialVersionUID = 188833125412428821L;

    @ApiModelProperty(value = "用户名", dataType = "String", required = true)
    private String userName;

    @ApiModelProperty(value = "用户密码", dataType = "String", required = true)
    private String password;

}
