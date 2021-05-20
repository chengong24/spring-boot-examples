package com.neo.java8;

import java.util.function.Function;

/**
 * @author chengong
 * @date 2020/7/26 2:41 下午
 */
public class FunctionTest {
    static int modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function) {
        return function.apply(valueToBeOperated);
    }

    public static Integer modifyTheValue2(int value, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        //value作为function1的参数，返回一个结果，该结果作为function2的参数，返回一个最终结果
        return function1.andThen(function2).apply(value);
    }


    public static Function<Integer, String> modifyTheValue2() {
        //value作为function1的参数，返回一个结果，该结果作为function2的参数，返回一个最终结果
        return val -> "" + val + 2;
    }


    public static void main(String[] args) {
        System.out.println(modifyTheValue2().apply(3));

//        System.out.println(modifyTheValue2(3, modifyTheValue2(), val -> val + 3));

    }
}
