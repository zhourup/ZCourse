package com.zhourup.zcourse.constant;

/**
 * 状态码常量类
 *
 * @author zhourup
 * @date 2022/4/28 21:46
 */
public class ResponseCodeConst {


    /**
     * 系统code
     */
    public static final ResponseCodeConst SUCCESS = new ResponseCodeConst(200, "操作成功");

    public static final ResponseCodeConst ERROR_PARAM = new ResponseCodeConst(101, "参数异常！");

    public static ResponseCodeConst JSON_FORMAT_ERROR = new ResponseCodeConst(102, "JSON格式错误");

    public static ResponseCodeConst REQUEST_METHOD_ERROR = new ResponseCodeConst(103, "请求方式错误");

    public static final ResponseCodeConst SYSTEM_ERROR = new ResponseCodeConst(104, "系统错误");

    /**
     * 登录code
     */
    public static final ResponseCodeConst LOGIN_ERROR = new ResponseCodeConst(1001, "您还未登录或登录失效，请重新登录！");

    /**
     * 用户名或密码错误
     */
    public static final ResponseCodeConst LOGIN_FAILED = new ResponseCodeConst(1002, "用户名或密码错误!");

    /**
     * 账号被禁用
     */
    public static final ResponseCodeConst IS_DISABLED = new ResponseCodeConst(1003, "您的账号已被禁用，不得登录系统!");

    protected int code;

    protected String msg;

    public ResponseCodeConst(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
