package com.zhourup.zcourse.auth.controller;

import com.zhourup.zcourse.auth.dto.UserLoginFormDTO;
import com.zhourup.zcourse.auth.service.LoginService;
import com.zhourup.zcourse.common.api.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录授权
 *
 * @author zhourup
 * @date 2022/3/28 16:42
 */
@RestController
@RequestMapping("auth")
@Api("登录接口")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("/login")
    public ResponseDTO<?> login(@RequestBody UserLoginFormDTO loginForm, HttpServletRequest request) {
        return loginService.login(loginForm, request);
    }
}
