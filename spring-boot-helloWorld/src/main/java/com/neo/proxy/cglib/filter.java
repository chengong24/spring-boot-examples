package com.neo.proxy.cglib;

/**
 * @author: Chen Gong
 * @date：2021/4/6$ 10:54 上午$
 */

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class filter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        System.out.println("=======accept======" + method.getName());
        if (method.getName().equals("say")) {
            return 1;
        }
        return 0;
    }
}
