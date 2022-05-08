package com.zhourup.zcourse.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zhourup
 * @date 2022/4/29 11:20
 */
@Data
public class UserLoginFormDTO {

    @NotNull(message = "登录名不能为空")
    private String loginName;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-11个字符")
    private String loginPwd;

}
