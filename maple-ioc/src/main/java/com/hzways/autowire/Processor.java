package com.hzways.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Processor {

    @Autowired
    private Person man;

    //这个会报错
//    @Autowired
//    private Person person;

    public void run() {
        man.run();
    }

}
