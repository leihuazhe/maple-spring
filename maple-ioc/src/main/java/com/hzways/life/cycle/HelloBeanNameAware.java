package com.hzways.life.cycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * desc: 生命周期
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:18
 */
@Component
public class HelloBeanNameAware implements BeanNameAware {


    @Override
    public void setBeanName(String name) {
        System.out.println("HelloBeanNameAware的bean name is: " + name);
    }
}