package com.neo.reflection;

import org.reflections.Reflections;

import java.util.Set;

/**
 * @author chengong
 * @date 2020/6/29 3:19 下午
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Set<Class<? extends BaseRelection>> moduleClasses;
        Reflections moduleReflections = new Reflections("com.neo");
        moduleClasses = moduleReflections.getSubTypesOf(BaseRelection.class);
        BaseRelection baseRelection = moduleClasses.iterator().next().newInstance();
        System.out.println(moduleClasses.size());
        System.out.println(baseRelection.getClass().getPackage());
    }
}
