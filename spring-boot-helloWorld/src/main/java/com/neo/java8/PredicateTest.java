package com.neo.java8;

import java.util.function.Predicate;

/**
 * @author chengong
 * @date 2020/7/26 3:13 下午
 */
public class PredicateTest {
    public static boolean predicateTest(int value, Predicate<Integer> predicate) {
        return predicate.test(value);
    }
    public static void main(String[] args) {
        // (x) -> x == 3 输入一个参数x，进行比较操作，返回一个布尔值
        // 所以该lambda表达式可以实现Predicate接口
        System.out.println(predicateTest(3, (x) -> x == 3));
    }
}
