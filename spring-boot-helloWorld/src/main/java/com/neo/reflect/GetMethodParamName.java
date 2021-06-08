package com.neo.reflect;

import org.springframework.core.DefaultParameterNameDiscoverer;

import java.lang.reflect.Method;

/**
 * @author: Chen Gong
 * @date：2021/4/24 6:49 下午
 */
public class GetMethodParamName {
    public static void main(String[] args) throws NoSuchMethodException {
        GetMethodParamName getMethodParamName = new GetMethodParamName();
        Class clazz = getMethodParamName.getClass();
        Method getInfo = clazz.getDeclaredMethod("main", String[].class);
        String[] parameterNames = getParameterNames(getInfo);
        System.out.println(parameterNames[0]);
    }


    public static String[] getParameterNames(Method method) {
        return new DefaultParameterNameDiscoverer().getParameterNames(method);
    }
}
