package com.demo.base.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author:autumn
 * @date: 2019/11/18 11:23 PM
 * @description:
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RUNTIME)
public @interface MyAnnatation {
    String value();
}
