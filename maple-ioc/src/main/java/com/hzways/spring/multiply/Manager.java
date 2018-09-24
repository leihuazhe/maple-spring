package com.hzways.spring.multiply;


/**
 * @author maple 2018.09.10 下午10:27
 */
public class Manager implements Test{
    private static int counter = 0;

    private String beanName;


    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Manager() {
        System.out.println("===========> ===========>  Manager counter :" + (++counter));
    }

    public void hello() {
        System.out.println("===========> ===========>  hello world, counter is " + counter + ", name is " + beanName);
    }
}
