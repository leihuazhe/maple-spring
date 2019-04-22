package com.hzways.autowire;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {

    @Override
    public void run() {
        System.out.println("man running....");
    }
}
