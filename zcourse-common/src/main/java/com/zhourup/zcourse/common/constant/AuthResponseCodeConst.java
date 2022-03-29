package com.zhourup.zcourse.common.constant;

/**
 * 授权常量类
 *
 * @author zhourup
 * @date 2022/3/28 21:26
 */
public class AuthResponseCodeConst extends ResponseCodeConst {

    /**
     * 用户名或密码错误
     */
    public static final AuthResponseCodeConst LOGIN_FAILED = new AuthResponseCodeConst(1001, "用户名或密码错误!");

    /**
     * 没有携带TOKEN
     */
    public static final AuthResponseCodeConst NOT_TOKEN = new AuthResponseCodeConst(1002, "没有携带Token!");


    public AuthResponseCodeConst(int code, String msg) {
        super(code, msg);
    }
}
