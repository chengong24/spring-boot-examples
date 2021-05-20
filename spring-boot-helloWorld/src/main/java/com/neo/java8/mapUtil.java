package com.neo.java8;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Chen Gong
 * @date：2021/4/15 2:40 下午
 */
public class mapUtil {
    private static final Map<String, String> moduleUriCache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            moduleUriCache.computeIfAbsent(i + "dfdafdf", k -> {
                String application = k.replace('_', '-');
                return "http://" + application;

            });
        }

        System.out.println();

    }
}
