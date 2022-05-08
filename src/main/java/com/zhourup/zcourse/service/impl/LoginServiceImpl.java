package com.zhourup.zcourse.service.impl;

import com.zhourup.zcourse.common.domain.ResponseDTO;
import com.zhourup.zcourse.constant.ResponseCodeConst;
import com.zhourup.zcourse.constant.SystemStatusEnum;
import com.zhourup.zcourse.dao.UserDao;
import com.zhourup.zcourse.domain.dto.UserDTO;
import com.zhourup.zcourse.domain.dto.UserLoginFormDTO;
import com.zhourup.zcourse.domain.vo.KaptchaVO;
import com.zhourup.zcourse.domain.vo.LoginDetailVO;
import com.zhourup.zcourse.service.LoginService;
import com.zhourup.zcourse.util.JwtUtils;
import com.zhourup.zcourse.util.ZCourseBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhourup
 * @date 2022/4/29 11:32
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseDTO<LoginDetailVO> login(UserLoginFormDTO loginForm, HttpServletRequest request) {
        //对密码解密

        //根据账号、密码查询相应的用户
        UserDTO userDTO = userDao.login(loginForm.getLoginName(), loginForm.getLoginPwd());
        if (null == userDTO) {
            //查询为空，登录失败
            return ResponseDTO.wrap(ResponseCodeConst.LOGIN_FAILED);
        }
        //如果用户被禁用，返回被禁用
        if (SystemStatusEnum.DISABLED.getValue().equals(userDTO.getIsDelete())) {
            return ResponseDTO.wrap(ResponseCodeConst.IS_DISABLED);
        }

        //生成jwt token
        String token = jwtUtils.generateToken(userDTO.getId());
        //定义返回对象LoginDetailVO并赋值各项
        LoginDetailVO loginDetailVO = ZCourseBeanUtil.copy(userDTO, LoginDetailVO.class);
        loginDetailVO.setXAccessToken(token);

        //将登录日志交给中间件

        return ResponseDTO.succData(loginDetailVO);
    }

    @Override
    public ResponseDTO<Boolean> logOut() {
        return null;
    }

    @Override
    public ResponseDTO<KaptchaVO> verificationCode() {
        return null;
    }
}
