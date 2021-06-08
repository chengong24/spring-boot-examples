package com.neo.mvc;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

/**
 * @author stan
 * @date 2021/4/17
 */
public class RPCRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {


    public RPCRequestMappingHandlerAdapter() {

    }

    @Override
    protected @NotNull ServletInvocableHandlerMethod createInvocableHandlerMethod(@NotNull HandlerMethod handlerMethod) {
        return new RPCServletMethodHandler(handlerMethod);
    }
}
