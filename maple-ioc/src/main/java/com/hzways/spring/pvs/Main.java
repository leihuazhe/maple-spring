package com.hzways.spring.pvs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc: 1
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:56
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:services7.xml");
        applicationContext.start();


        Manager manager = (Manager) applicationContext.getBean("manager");

        System.out.println(manager.toString());

        Thread.sleep(Long.MAX_VALUE);

    }
}
