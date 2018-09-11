package com.hzways.life.cycle;

import org.springframework.context.Lifecycle;
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
//@Component
public class HelloLifeCycle implements Lifecycle {
    private volatile boolean running = false;


    private ExecutorService executors = Executors.newFixedThreadPool(1);

    public HelloLifeCycle() {
        System.out.println("HelloLifeCycle 构造方法!!!");
        executors.execute(() -> {
            while (running) {
               //启动后,做业务需要做的事情
            }
        });
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
            e.printStackTrace();
        }
        running = false;
    }

    public boolean isRunning() {
        return running;
    }


    public void thinking() throws InterruptedException {
        executors.execute(() -> {
            System.out.println("需要睡眠20s");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
            }
            System.out.println("睡眠结束！！");

        });
    }
}