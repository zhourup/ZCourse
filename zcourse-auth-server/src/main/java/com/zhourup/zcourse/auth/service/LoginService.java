package com.zhourup.zcourse.auth.service;

import com.zhourup.zcourse.auth.dto.UserLoginFormDTO;
import com.zhourup.zcourse.common.api.ResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 登录
 *
 * @author zhourup
 * @date 2022/3/28 17:35
 */
public interface LoginService {

    /**
     * 登录授权
     *
     * @param loginForm
     * @param request
     * @return
     */
    ResponseDTO<?> login(@Valid @RequestBody UserLoginFormDTO loginForm, HttpServletRequest request);
}
