package com.neo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengong
 * @date 2020/11/5 4:52 下午
 */
public class Filter {
    public static void main(String[] args) {
        ArrayList<String> aa = new ArrayList<String>();
        aa.add("a");
        aa.add("b");
        List<String> a1 = aa.stream().filter(a -> a.equals("a")).collect(Collectors.toList());
        System.out.println(a1.get(0));

    }
}
