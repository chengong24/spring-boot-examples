package com.neo.proxy.cglib;

/**
 * @author: Chen Gong
 * @date：2021/4/6 10:52 上午
 * @desc
 */

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CglibProxy2 implements MethodInterceptor {

    //实现MethodInterceptor接口，定义方法的拦截器
    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("pre1");
        //通过代理类调用父类中的方法,即实体类方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after1");
        return result;
    }
}