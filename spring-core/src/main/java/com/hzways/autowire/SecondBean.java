package com.hzways.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("person")
public class SecondBean {

    public void run() {
        System.out.println("SecondBean");
    }

}
