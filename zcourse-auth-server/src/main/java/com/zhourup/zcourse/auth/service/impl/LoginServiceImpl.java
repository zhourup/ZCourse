package com.zhourup.zcourse.auth.service.impl;

import com.zhourup.zcourse.auth.dto.UserLoginFormDTO;
import com.zhourup.zcourse.auth.service.LoginService;
import com.zhourup.zcourse.common.api.ResponseDTO;
import com.zhourup.zcourse.common.constant.AuthResponseCodeConst;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 认证授权实现类
 *
 * @author zhourup
 * @date 2022/3/28 17:37
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public ResponseDTO<?> login(@Valid UserLoginFormDTO loginForm, HttpServletRequest request) {
        String loginName = loginForm.getLoginName();
        String loginPwd = loginForm.getLoginPwd();
        if (loginName.equals("admin") && loginPwd.equals("123456")) {
            return ResponseDTO.succ();
        }
        return ResponseDTO.wrap(AuthResponseCodeConst.LOGIN_FAILED);
    }
}
