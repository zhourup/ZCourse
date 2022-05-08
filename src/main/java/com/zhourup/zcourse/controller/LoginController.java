package com.zhourup.zcourse.controller;

import com.zhourup.zcourse.common.anno.NoNeedLogin;
import com.zhourup.zcourse.common.domain.ResponseDTO;
import com.zhourup.zcourse.domain.dto.UserLoginFormDTO;
import com.zhourup.zcourse.domain.vo.LoginDetailVO;
import com.zhourup.zcourse.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author zhourup
 * @date 2022/4/28 21:41
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/session/login")
    @ApiOperation(value = "登录", notes = "登录")
    @NoNeedLogin
    public ResponseDTO<LoginDetailVO> login(@RequestBody @Valid UserLoginFormDTO loginFrom, HttpServletRequest request) {
        return loginService.login(loginFrom, request);
    }

}
