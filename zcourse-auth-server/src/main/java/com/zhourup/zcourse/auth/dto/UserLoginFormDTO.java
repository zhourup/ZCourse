package com.zhourup.zcourse.auth.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 登录
 *
 * @author zhourup
 * @date 2022/3/28 17:31
 */
@Data
public class UserLoginFormDTO {

    @NotNull(message = "登录名不能为空")
    @ApiModelProperty(example = "admin")
    private String loginName;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(example = "123456")
    private String loginPwd;
}
