package com.neo.annotation;

/**
 * @author: Chen Gong
 * @date：2021/4/24 5:39 下午
 */
@ClassAnnotation
public class A {
    @FieldAnnotation
    private String field;

    @MethodAnnotation
    public void fun() {
        System.out.println(field);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
