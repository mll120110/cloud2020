package com.atguigu.springcloud.user.entity;

import javax.validation.constraints.NotNull;

import com.atguigu.springcloud.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "BdUser对象", description = "")
public class BdUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键", hidden = true)
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    @ApiModelProperty(value = "用户登录账户", required = true, position = 0)
    @NotNull
    private String userAccount;

    @ApiModelProperty(value = "用户name", required = true, position = 1)
    private String userName;

    @ApiModelProperty(value = "用户状态0无效，1有效", required = true, position = 2)
    private Integer state;

    @ApiModelProperty(value = "用户权限0超级管理员，1普通用户", required = true, position = 3)
    private Integer permission;
}
