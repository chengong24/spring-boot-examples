package com.neo.reflect;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Chen Gong
 * @date：2021/4/7 2:44 下午
 */
public class TestRef {

    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Foo foo = new Foo("这个一个Foo对象！");
        Class clazz = foo.getClass();
        Method getInfo = clazz.getDeclaredMethod("getInfo", Info.class,String.class);
        getInfo.invoke(foo, new Info("ddd"),"dfdfd");
    }
}

class Foo {
    private String msg;

    public Foo(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void getInfo(Info msg, String msg2) {
        System.out.println(msg.getA());
        System.out.println(msg2);
    }

    public String getMsg() {
        return msg;
    }

    public void outInfo() {
        System.out.println("这是测试Java反射的测试类");
    }
}

@Data
class Info {

    String a;

    public Info(String a) {
        this.a = a;
    }

    public void print() {
        System.out.println(a);
    }
}
