package com.zhourup.zcourse.common.domain;

import com.zhourup.zcourse.constant.ResponseCodeConst;

/**
 * 返回类
 *
 * @author zhourup
 * @date 2022/4/28 21:43
 */
public class ResponseDTO<T> {

    protected Integer code;

    protected String msg;

    protected T data;

    public ResponseDTO() {
    }

    public ResponseDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseDTO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseDTO(ResponseCodeConst responseCodeConst, T data) {
        this.code = responseCodeConst.getCode();
        this.msg = responseCodeConst.getMsg();
        this.data = data;
    }

    private ResponseDTO(ResponseCodeConst responseCodeConst) {
        this.code = responseCodeConst.getCode();
        this.msg = responseCodeConst.getMsg();
    }

    private ResponseDTO(ResponseCodeConst responseCodeConst, String msg) {
        this.code = responseCodeConst.getCode();
        this.msg = msg;
    }

    public static <T> ResponseDTO<T> succ() {
        return new ResponseDTO<>(ResponseCodeConst.SUCCESS);
    }

    public static <T> ResponseDTO<T> succData(T data) {
        return new ResponseDTO<>(ResponseCodeConst.SUCCESS, data);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst) {
        return new ResponseDTO<>(codeConst);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst, String msg) {
        return new ResponseDTO<>(codeConst, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
