package com.ktz.deploy.log.annotation;

import java.lang.annotation.*;

/**
 * @Author kaituozhesh
 * @Description
 * @Date 9:59 2020/3/16
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    String moduleCode() default "";
}
