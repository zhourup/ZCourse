package com.zhourup.zcourse.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息DTO
 *
 * @author zhourup
 * @date 2022/5/4 11:27
 */
@Data
public class UserDTO {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("登录账号")
    private String loginName;

    @ApiModelProperty("实际姓名")
    private String actualName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("生日")
    private String birthday;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("是否被删除")
    private Integer isDelete;
}
