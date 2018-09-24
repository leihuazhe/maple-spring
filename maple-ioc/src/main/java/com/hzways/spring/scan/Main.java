package com.hzways.spring.scan;

import com.hzways.spring.scan.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc: 1
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:56
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:services5.xml");
        applicationContext.start();


        HelloService service = applicationContext.getBean(HelloService.class);

        String maple = service.sayHello("maple");


        System.out.println("=====> Main,call: " + maple);

        Thread.sleep(Long.MAX_VALUE);

    }
}
