package com.neo.annotation;

import io.github.classgraph.*;

/**
 * @author: Chen Gong
 * @date：2021/4/24 5:41 下午
 */
public class Main {
    public static void main(String[] args) {
        ScanResult scanResult = new ClassGraph().whitelistPackages("com.neo.annotation").enableAllInfo().scan();
        // 获取类级别注解
        ClassInfoList classesWithAnnotation = scanResult.getClassesWithAnnotation(ClassAnnotation.class.getName());
        for (ClassInfo classInfo : classesWithAnnotation) {
            ClassAnnotation classAnnotation = (ClassAnnotation) classInfo.getAnnotationInfo(ClassAnnotation.class.getName()).loadClassAndInstantiate();
            if (classAnnotation != null) {
                System.out.println(classAnnotation.a());
                // 处理方法级别
                for (MethodInfo methodInfo : classInfo.getDeclaredMethodInfo()) {
                    MethodAnnotation methodAnnotation = null;
                    try {
                        methodAnnotation = (MethodAnnotation) methodInfo.getAnnotationInfo(MethodAnnotation.class.getName()).loadClassAndInstantiate();
                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
                    }
                    if (methodAnnotation != null) {
                        System.out.println(methodAnnotation.a());

                    }
                }
                // 获取字段注解
                FieldInfoList fieldInfos = classInfo.getFieldInfo();
                for (FieldInfo fieldInfo : fieldInfos) {
                    FieldAnnotation methodAnnotation = (FieldAnnotation) fieldInfo.getAnnotationInfo(FieldAnnotation.class.getName()).loadClassAndInstantiate();
                    if (methodAnnotation != null) {
                        System.out.println(methodAnnotation.a());

                    }
                }
            }
        }
    }
}
