package com.neo.test;

/**
 * @author: Chen Gong
 * @date：2021/4/21 8:15 下午
 */
public class Parent {
    int a;

    public Parent(int a) {
        this.a = 3;
        System.out.println("parent int a" + a);
    }

    public Parent() {
        System.out.println("parent");
    }

}
