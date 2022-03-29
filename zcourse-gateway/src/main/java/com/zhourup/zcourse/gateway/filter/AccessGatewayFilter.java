package com.zhourup.zcourse.gateway.filter;

import com.zhourup.zcourse.common.constant.Oauth2Constant;
import com.zhourup.zcourse.common.constant.ZCourseConstant;
import com.zhourup.zcourse.gateway.props.ZCourseApiProperties;
import com.zhourup.zcourse.gateway.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 请求url权限校验
 *
 * @author zhourup
 * @date 2022/3/26 17:19
 */
@Component
@AllArgsConstructor
public class AccessGatewayFilter implements GlobalFilter {

    private final ZCourseApiProperties courseApiProperties;

    /**
     * 1
     * 2
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //如果未启用网关验证，则跳过
        if (!courseApiProperties.getEnable()) {
            return chain.filter(exchange);
        }

        //如果在忽略的url里，则跳过

        //验证token是否有效
        ServerHttpResponse resp = exchange.getResponse();
        String headerToken = exchange.getRequest().getHeaders().getFirst(Oauth2Constant.HEADER_TOKEN);
        if (headerToken == null) {
            return unauthorized(resp, "没有携带Token信息！");
        }

        return chain.filter(exchange);
    }

    private Mono<Void> unauthorized(ServerHttpResponse resp, String msg) {
        return ResponseUtil.responseWriter(resp, ZCourseConstant.JSON_UTF8, HttpStatus.UNAUTHORIZED, msg);
    }

}
