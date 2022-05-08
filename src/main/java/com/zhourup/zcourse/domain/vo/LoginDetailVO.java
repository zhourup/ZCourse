package com.zhourup.zcourse.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 登录返回DTO
 *
 * @author zhourup
 * @date 2022/4/29 22:33
 */
@Data
public class LoginDetailVO {

    @ApiModelProperty("登录账号")
    private String loginName;

    @ApiModelProperty("真实姓名")
    private String actualName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("登录token")
    private String xAccessToken;
}
