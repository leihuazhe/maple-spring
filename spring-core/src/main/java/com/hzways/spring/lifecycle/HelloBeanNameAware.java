package com.hzways.spring.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

/**
 * desc: 生命周期
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:18
 */
//@Component
public class HelloBeanNameAware implements BeanNameAware {


    @Override
    public void setBeanName(String name) {
        System.out.println("HelloBeanNameAware的bean name is: " + name);
    }
}