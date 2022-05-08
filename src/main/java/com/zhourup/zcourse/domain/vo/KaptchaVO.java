package com.zhourup.zcourse.domain.vo;

import lombok.Data;

/**
 * @author zhourup
 * @date 2022/4/29 21:02
 */
@Data
public class KaptchaVO {

    /**
     * 验证码UUID
     */
    private String uuid;

    /**
     * base64 验证码
     */
    private String code;
}
