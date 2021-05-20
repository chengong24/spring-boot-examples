package com.neo.fanxing.classtype;

/**
 * @author chengong
 * @date 2020/11/28 3:02 下午
 */
public class Test {
    public static void main(String[] args) {
//        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Long> longValue = new Generic<>(456L);
        Long key = longValue.getKey();
    }
}
