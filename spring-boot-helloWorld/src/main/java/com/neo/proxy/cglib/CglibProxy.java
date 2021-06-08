package com.neo.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
/**
 * @author: Chen Gong
 * @date：2021/4/6 10:48 上午
 * @desc
 */
public class CglibProxy implements MethodInterceptor {

    //实现MethodInterceptor接口，定义方法的拦截器
    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("pre");
        //通过代理类调用父类中的方法,即实体类方法
//        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return new Object();
    }
}
