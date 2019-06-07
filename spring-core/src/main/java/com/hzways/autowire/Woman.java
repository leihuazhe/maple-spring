package com.hzways.autowire;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person {

    @Override
    public void run() {
        System.out.println("Woman running....");
    }
}
