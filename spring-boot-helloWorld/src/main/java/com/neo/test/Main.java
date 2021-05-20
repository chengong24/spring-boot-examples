package com.neo.test;

/**
 * @author: Chen Gong
 * @date：2021/4/21 8:18 下午
 */
public class Main {
    public static void main(String[] args) {
        int j = 7;
        for (int i = 4; i < 10; i++) {
            j = ++j;
        }
        System.out.println(j);
    }
}
