package com.zhourup.zcourse.gateway.util;

import com.alibaba.fastjson.JSONObject;
import com.zhourup.zcourse.common.api.ResponseDTO;
import com.zhourup.zcourse.common.constant.ResponseCodeConst;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * 响应工具
 *
 * @author zhourup
 * @date 2022/3/27 20:34
 */
public class ResponseUtil {

    /**
     * 给请求端响应相应的状态码和信息
     *
     * @param response    ServerHttpResponse
     * @param contentType content-type
     * @param status      http状态码
     * @param value       响应内容
     * @return Mono<Void>
     */
    public static Mono<Void> responseWriter(ServerHttpResponse response, String contentType,
                                            HttpStatus status, Object value) {
        response.setStatusCode(status);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, contentType);
        ResponseDTO result = ResponseDTO.wrap(ResponseCodeConst.NOT_TOKEN);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSONObject.toJSONString(result).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }
}
