package com.hzways.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("services8.xml");

        Processor processor = context.getBean(Processor.class);
//        SecondBean secondBean = context.getBean(SecondBean.class);
//        secondBean.run();

        processor.run();
    }
}
