package com.hzways.life.cycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * desc: 生命周期
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:18
 */
@Component
public class HelloLifeCycle1 implements InitializingBean, DisposableBean {
    private volatile boolean running = false;

    private ExecutorService executors = Executors.newFixedThreadPool(1);

    public HelloLifeCycle1() {
        System.out.println("HelloLifeCycle1 构造方法!!!");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("HelloLifeCycle1 afterPropertiesSet 启动");
    }


    public void destroy() throws Exception {
        System.out.println("HelloLifeCycle1 DisposableBean 停止");
    }


    public void start() {
        System.out.println("lifycycle start");
        running = true;

    }

    public void stop() {
        System.out.println("lifycycle stop ,and stop the execute");
        executors.shutdown();
        try {
            executors.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
        }
        running = false;
    }

    public boolean isRunning() {
        return running;
    }


}