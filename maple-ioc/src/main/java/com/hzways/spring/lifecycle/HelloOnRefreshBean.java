package com.hzways.spring.lifecycle;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * desc: 生命周期
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:18
 */
//@Component
public class HelloOnRefreshBean implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloOnRefreshBean -> ContextRefreshedEvent:" + event.getSource().toString());
    }

}