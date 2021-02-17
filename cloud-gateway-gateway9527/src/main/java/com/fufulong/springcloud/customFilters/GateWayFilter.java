package com.fufulong.springcloud.customFilters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
public class GateWayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("------come in MyGlobalFilter : "+ new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        //合法性检验
        if(uname == null){
            System.out.println("----用户名为null,非法用户，请求不被接受");
            //设置 response 状态码   因为在请求之前过滤的，so就算是返回NOT_FOUND 也不会返回错误页面
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            //完成请求调用
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 全局的一般第1位加载, 数字越小的越先被加载
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
