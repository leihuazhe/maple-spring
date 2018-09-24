package com.hzways.spring.multiply;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc: 1
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:56
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:services3.xml");
        applicationContext.start();


        Test helloWorld = (Test) applicationContext.getBean("manager");

        helloWorld.hello();

        Thread.sleep(Long.MAX_VALUE);

    }
}
