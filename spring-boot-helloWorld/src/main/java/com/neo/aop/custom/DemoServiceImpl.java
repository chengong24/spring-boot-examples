package com.neo.aop.custom;

import org.springframework.stereotype.Service;

/**
 * @author: Chen Gong
 * @date：2021/5/20 11:29 上午
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Override
    @Log
    public void add(int a, int b) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(a + b);

    }

}
