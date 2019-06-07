package com.hzways.spring.post.processor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc: 1
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:56
 */
public class Main {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:services.xml");
        applicationContext.start();

        System.err.println("applicationContext started ... ");


//        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);

//        helloWorld.hello();

        Thread.sleep(2000);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        applicationContext = new ClassPathXmlApplicationContext("classpath*:services.xml");
        applicationContext.start();


        System.err.println("applicationContext1 started ... ");

        Thread.sleep(Long.MAX_VALUE);

    }
}
