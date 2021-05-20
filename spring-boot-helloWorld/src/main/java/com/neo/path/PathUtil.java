package com.neo.path;

import org.springframework.util.AntPathMatcher;

import java.util.Map;

/**
 * @author: Chen Gong
 * @date：2021/4/7 5:03 下午
 */
public class PathUtil {

    public static void main(String[] args) {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        Map<String, String> uriVariables = pathMatcher.extractUriTemplateVariables( "/test/{1}/{2}","/test/name/age");
        System.out.println(uriVariables);
    }
}
