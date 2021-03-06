package com.atguigu.springcloud.common;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Jack_Road
 * @date 2019/8/29 11:13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "BaseEntity对象", description = "基础实体类，共用相关字段")
public class BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建时间", required = true, example = "2020-11-11 20:20:20")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", required = true, example = "2020-11-11 20:20:20")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
