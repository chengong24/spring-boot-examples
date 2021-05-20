package com.neo.classgraph;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.lang.reflect.Modifier;

/**
 * @author: Chen Gong
 * @date：2021/4/23 5:06 下午
 */
public class Main {
    public static void main(String[] args) {
        ScanResult scanResult = new ClassGraph().enableAllInfo().whitelistPackages("com.neo.classgraph").scan();
        ClassInfoList classInfos = scanResult.getClassesImplementing(AInterface.class.getName());
        for (ClassInfo classInfo : classInfos) {
            int modifiers = classInfo.getModifiers();
            if (Modifier.isAbstract(modifiers) || Modifier.isInterface(modifiers)) {
                continue;
            }
            Class<?> handlerClass = classInfo.loadClass();
            AInterface aInterface;
            try {
                aInterface = (AInterface) handlerClass.newInstance();
                aInterface.fun();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new IllegalArgumentException("Class " + handlerClass.getName() + " without no args construct");
            }
        }
    }
}
