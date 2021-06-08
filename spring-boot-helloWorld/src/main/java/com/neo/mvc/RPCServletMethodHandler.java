package com.neo.mvc;

import org.jetbrains.annotations.NotNull;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * @author stan
 * @date 2021/4/17
 */
public class RPCServletMethodHandler extends ServletInvocableHandlerMethod {


    private final Collection<String> excludeUrlPatterns = Arrays.asList(
            "/actuator/health", // fast assert
            "/actuator/*",
            "/actuator"
    );

    private final PathMatcher pathMatcher = new AntPathMatcher();

    private boolean shouldNotFilter(@NotNull HttpServletRequest request) {
        return excludeUrlPatterns.stream()
                .anyMatch(p -> pathMatcher.match(p, request.getServletPath()));
    }


    public RPCServletMethodHandler(Object handler, Method method) {
        super(handler, method);
    }

    public RPCServletMethodHandler(HandlerMethod handlerMethod) {
        super(handlerMethod);
    }

    @Override
    public Object invokeForRequest(@NotNull NativeWebRequest request,
                                   ModelAndViewContainer mavContainer,
                                   Object @NotNull ... providedArgs) throws Exception {
        Object[] args = getMethodArgumentValues(request, mavContainer, providedArgs);
        if (logger.isTraceEnabled()) {
            logger.trace("Arguments: " + Arrays.toString(args));
        }

        // 忽略 health check 之类的请求
        if (shouldNotFilter(Objects.requireNonNull(request
                .getNativeRequest(HttpServletRequest.class)))) {
            return super.doInvoke(args);
        } else {
            return doInvoke(args);
        }
    }

    @Override
    protected Object doInvoke(Object @NotNull ... args) throws Exception {

        return super.doInvoke(args);
    }
}
