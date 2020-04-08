package com.springboot.demo.springbootdemo.annotation;

import java.lang.annotation.*;

/**
 *
 *
 * @author hz
 * @create 2020-04-08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default "";
}
