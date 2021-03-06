package com.atguigu.springcloud.user.entity;

import com.atguigu.springcloud.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * BdDevice对象
 * 
 * @author Jack Road
 * @since 2019-08-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "BdDevice对象", description = "")
public class BdDevice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "device_id", type = IdType.UUID)
    @ApiModelProperty(value = "设备id", required = true)
    private String deviceId;

    @ApiModelProperty(value = "设备name", required = true)
    private String deviceName;

    @ApiModelProperty(value = "设备号", required = true)
    private Long deviceNumber;

    @ApiModelProperty(value = "设备状态0无效，1有效", required = true)
    private Integer state;
}
