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
        HelloLifeCycle helloLifeCycle = (HelloLifeCycle) applicationContext.getBean("helloLifeCycle");
        helloLifeCycle.thinking();
        Thread.sleep(20000);
        applicationContext.destroy();
    }
}
