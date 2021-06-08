package com.neo.fanxing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chengong
 * @date 2020/11/28 2:51 下午
 */
public class Test<T> {
    private T key;

    public static void main(String[] args) {
//        test1();
//        test2();
//        Test<Long> longTest = new Test<>(19L);
//        Long serializable = (Long)longTest.test3();
//        System.out.println(serializable);
        test4();
    }

    public Test(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }
    public T getKey() { //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }


    private static void test1() {
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            Object item = arrayList.get(i);
            System.out.println("泛型测试 item = " + item);
        }
    }

    private static void test2() {
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("类型相同");
        }
    }

    public <T extends Serializable> T test3() {
        Object currentBusinessDimension = 1111;
        if (currentBusinessDimension == null) {
            return null;
        }
        return (T) currentBusinessDimension;
    }


    public static void test4(){
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "hello");
        map.put("world", "world");
        System.out.println(map.get("hello"));
        System.out.println(map.get("world"));
    }


}
