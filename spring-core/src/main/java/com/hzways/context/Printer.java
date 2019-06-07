package com.hzways.context;

import org.springframework.stereotype.Component;

@Component
public class Printer {

    public String printName() {
        return "Printer ---> maple";
    }

}
