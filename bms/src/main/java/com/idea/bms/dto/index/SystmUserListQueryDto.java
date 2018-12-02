package com.idea.bms.dto.index;

import com.idea.common.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统用户列表查询参数")
@Data
public class SystmUserListQueryDto extends PageDto implements Serializable {
    private static final long serialVersionUID = -5526466440194482544L;

    @ApiModelProperty(value = "用户账号",dataType = "String")
    private String userName;

    @ApiModelProperty(value = "状态 0=正常 1=禁用",dataType = "Integer")
    private Integer status;

    @ApiModelProperty(value = "用户名",dataType = "String")
    private String name;

    @ApiModelProperty(value = "手机号",dataType = "String")
    private String mobile;

}
