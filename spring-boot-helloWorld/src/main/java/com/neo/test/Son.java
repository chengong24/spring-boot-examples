package com.neo.test;

/**
 * @author: Chen Gong
 * @date：2021/4/21 8:17 下午
 */
public class Son extends Parent {
    int a;

    public Son(int a) {
        super(a);
        this.a = 2;
        System.out.println("son" + a);
    }
}
