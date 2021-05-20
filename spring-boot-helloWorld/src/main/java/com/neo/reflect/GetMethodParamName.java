package com.neo.reflect;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

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
        System.out.println(getParameterNames(getInfo)[0]);
    }

    public static final ParameterNameDiscoverer PARAMETER_NAME_DISCOVERER = new DefaultParameterNameDiscoverer();


    public static String[] getParameterNames(Method method) {
        return PARAMETER_NAME_DISCOVERER.getParameterNames(method);
    }
}
