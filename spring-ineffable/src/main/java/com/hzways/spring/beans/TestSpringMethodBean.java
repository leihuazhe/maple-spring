package com.hzways.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:
 *
 * @author hz.lei
 * @date 2018年04月13日 上午12:28
 */
public class TestSpringMethodBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:services.xml");
        HelloProcessor bean = context.getBean(HelloProcessor.class);
        bean.foo();


    }
}
