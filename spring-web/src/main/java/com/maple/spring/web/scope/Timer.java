package com.maple.spring.web.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Timer {

    private final DateBean dateBean;

    public Timer(DateBean dateBean) {
        this.dateBean = dateBean;
    }

    public void info(String tag) {
        String info = dateBean.info();
        System.out.println("Timer-" + tag + ":  " + info);
    }
}
