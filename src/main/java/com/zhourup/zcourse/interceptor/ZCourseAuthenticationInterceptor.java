package com.zhourup.zcourse.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.zhourup.zcourse.common.anno.NoNeedLogin;
import com.zhourup.zcourse.common.domain.ResponseDTO;
import com.zhourup.zcourse.constant.CommonConst;
import com.zhourup.zcourse.constant.ResponseCodeConst;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截器
 *
 * @author zhourup
 * @date 2022/5/5 13:18
 */
@Component
public class ZCourseAuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final String TOKEN_NAME = "x-access-token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置跨域
        this.crossDomainConfig(response);
        // 如果不是映射到方法则直接通过
        boolean isHandleMethod = handler instanceof HandlerMethod;
        if (!isHandleMethod) {
            return true;
        }

        // 请求的方法有不需要登录注解的直接通过
        boolean isNoNeedLogin = ((HandlerMethod) handler).getMethodAnnotation(NoNeedLogin.class) != null;
        if (isNoNeedLogin) {
            return true;
        }

        // 如果请求是Swagger的放行请求
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String target = uri.replaceFirst(contextPath, "");
        if (CommonConst.CommonCollection.contain(CommonConst.CommonCollection.IGNORE_URL, target)) {
            return true;
        }

        // token校验
        String xHeaderToken = request.getHeader(TOKEN_NAME);
        String xRequestToken = request.getParameter(TOKEN_NAME);
        String xAccessToken = null != xHeaderToken ? xHeaderToken : xRequestToken;
        if (null == xAccessToken) {
            this.outputResult(response, ResponseCodeConst.LOGIN_ERROR);
            return false;
        }

        // 根据token获取登录用户

        return false;
    }

    /**
     * 配置跨域
     *
     * @param response
     */
    private void crossDomainConfig(HttpServletResponse response) {
        // 设置允许s1发起跨域请求
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 设置允许Cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // 设置跨域请求包含content-type
        response.setHeader("Access-Control-Allow-Headers", "Authentication,Origin, X-Requested-With, Content-Type, " + "Accept, x-access-token");
        response.setHeader("Cache-Control", "no-cache");
    }

    private void outputResult(HttpServletResponse response, ResponseCodeConst responseCodeConst) throws IOException {
        ResponseDTO<Object> wrap = ResponseDTO.wrap(responseCodeConst);
        String msg = JSONObject.toJSONString(wrap);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(msg);
        response.flushBuffer();
    }
}
