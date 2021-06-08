package com.neo.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author: Chen Gong
 * @date：2021/5/19 8:54 上午
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        UserService proxy = (UserService) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(),
                new Class[]{UserService.class}, new MyInvocationHandler(new UserServiceImpl()));
        proxy.doSomething();
    }
}
