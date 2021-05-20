package com.neo.java8;

import java.util.function.Supplier;

/**
 * @author chengong
 * @date 2020/7/26 3:16 下午
 * 无参数，返回一个结果。
 */
public class SupplierTest {
    public static String supplierTest(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String args[]) {
        String name = "冷冷";
        // () -> name.length() 无参数，返回一个结果（字符串长度）
        // 所以该lambda表达式可以实现Supplier接口
        System.out.println(supplierTest(() -> name.length() + ""));
    }
}
