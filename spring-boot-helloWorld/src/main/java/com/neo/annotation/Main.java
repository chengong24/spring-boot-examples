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
            AnnotationInfo a1 = classInfo.getAnnotationInfo(ClassAnnotation.class.getName());
            if (a1 != null) {
                ClassAnnotation classAnnotation = (ClassAnnotation) a1.loadClassAndInstantiate();
                System.out.println(classAnnotation.a());
                // 处理方法级别
                for (MethodInfo methodInfo : classInfo.getDeclaredMethodInfo()) {
                    AnnotationInfo a2 = methodInfo.getAnnotationInfo(MethodAnnotation.class.getName());
                    if (a2 != null) {
                        MethodAnnotation methodAnnotation = (MethodAnnotation) a2.loadClassAndInstantiate();
                        System.out.println(methodAnnotation.a());
                    }
                }
                // 获取字段注解
                FieldInfoList fieldInfos = classInfo.getFieldInfo();
                for (FieldInfo fieldInfo : fieldInfos) {
                    AnnotationInfo a3 = fieldInfo.getAnnotationInfo(FieldAnnotation.class.getName());
                    if (a3 != null) {
                        FieldAnnotation fieldAnnotation = (FieldAnnotation) a3.loadClassAndInstantiate();
                        System.out.println(fieldAnnotation.a());

                    }
                }
            }
        }
    }
}
