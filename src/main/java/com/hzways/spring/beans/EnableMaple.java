package com.hzways.spring.beans;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * desc: EnableMaple
 *
 * @author hz.lei
 * @since 2018年05月30日 上午12:53
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(InnerBeanConfiguration.class)
public @interface EnableMaple {
}
