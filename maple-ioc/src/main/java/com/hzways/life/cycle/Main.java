package com.hzways.life.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc: 1
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:56
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:services.xml");
        applicationContext.registerShutdownHook();
        applicationContext.start();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("-->: "+beanDefinitionName);
        }
        System.out.println("Main spring started");
//        HelloLifeCycle helloLifeCycle = (HelloLifeCycle) applicationContext.getBean("helloLifeCycle");
//        helloLifeCycle.doSome();
//        Thread.sleep(Long.MAX_VALUE);

        applicationContext.getBean("simpleBeanPostProcessor");
    }
}
