package com.zhourup.zcourse.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author zhourup
 * @date 2022/5/3 21:24
 */
@Data
@TableName("t_user")
public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5545260686888795525L;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 实际姓名
     */
    private String actualName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否被删除
     */
    private int isDelete;

}
