package com.neo.aop.custom;

import java.lang.annotation.*;

/**
 * @author: Chen Gong
 * @date：2021/5/20 11:30 上午
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

}
