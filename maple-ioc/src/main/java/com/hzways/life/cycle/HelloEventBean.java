package com.hzways.life.cycle;

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
public class HelloEventBean implements ApplicationListener {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("ContextRefreshedEvent 容器启动");
        } else if (event instanceof ContextClosedEvent) {
            System.out.println("ContextClosedEvent 容器关闭");
            HelloLifeCycle bean = applicationContext.getBean(HelloLifeCycle.class);
            boolean running = bean.isRunning();
            System.out.println(running);
        }
    }


}