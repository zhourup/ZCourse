package com.zhourup.zcourse.service;

import com.zhourup.zcourse.common.domain.ResponseDTO;
import com.zhourup.zcourse.domain.dto.UserLoginFormDTO;
import com.zhourup.zcourse.domain.vo.KaptchaVO;
import com.zhourup.zcourse.domain.vo.LoginDetailVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhourup
 * @date 2022/4/29 11:31
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param userLoginFormDTO 登录表单
     * @param request          re
     * @return
     */
    ResponseDTO<LoginDetailVO> login(UserLoginFormDTO userLoginFormDTO, HttpServletRequest request);

    /**
     * 退出登录
     *
     * @return
     */
    ResponseDTO<Boolean> logOut();


    /**
     * 获取验证码
     *
     * @return
     */
    ResponseDTO<KaptchaVO> verificationCode();
}
