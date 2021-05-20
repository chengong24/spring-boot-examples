package com.neo.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Chen Gong
 * @date：2021/5/19 8:53 上午
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object origin;

    public MyInvocationHandler(Object origin) {
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start");
        Object result = method.invoke(origin, args);
        System.out.println("invoke end");
        return result;
    }
}