package com.hzways.spring.scan.annotation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author maple 2018.09.25 上午12:33
 */
@org.springframework.context.annotation.Configuration
@MapleScan("com.hzways.spring.scan.maple")
//@Component
public class Configuration implements SmartLifecycle ,InitializingBean {
    private volatile boolean isRunning = false;

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
    }

    @Override
    public void start() {
        System.out.println("Configuration is started ");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("Configuration is stopped ");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Configuration is started ");
    }
}
