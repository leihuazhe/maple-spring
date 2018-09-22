package com.hzways.factory.post;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc: 1
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:56
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:services4.xml");
        applicationContext.start();


        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);

        helloWorld.hello();


        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        Thread.sleep(Long.MAX_VALUE);

    }
}
