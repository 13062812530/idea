package com.idea.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("分页查询参数")
public class PageDto implements Serializable {

    @ApiModelProperty(value = "当前页数", dataType = "Integer")
    private Integer pageNo;

    @ApiModelProperty(value = "每页显示数", dataType = "Integer")
    private Integer pageSize;

    @ApiModelProperty(value = "分页偏移量", dataType = "Integer")
    private Integer offset;

    @ApiModelProperty(value = "总数", dataType = "Integer")
    private Integer total;

    public Integer getPageNo() {
        if (null == pageNo || 1 < pageNo) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (null == pageSize || 1 < pageSize) {
            return 10;
        }
        return pageSize;
    }

    public Integer getOffset() {
        return (pageNo - 1) * pageSize;
    }
}
