package com.hzways.life.cycle;

import org.springframework.stereotype.Component;

/**
 * desc: 生命周期
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:18
 */
@Component
public class SimpleBean {

    public SimpleBean() {
        System.out.println("SimpleBean");
    }
}