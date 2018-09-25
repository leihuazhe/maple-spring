package com.hzways.aop.ann;

import java.lang.annotation.*;

/**
 * @author maple 2018.09.25 上午11:16
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Maples {

    Maple[] value();
}
