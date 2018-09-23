package com.hzways.scan.maple;

import com.hzways.scan.Maple;

/**
 * @author maple 2018.09.23 下午3:26
 */
@Maple
public class HelloWorld {

    public String hello() {
        return "hello world";
    }

    public String hello(String msg) {
        return "hello, " + msg;
    }
}
