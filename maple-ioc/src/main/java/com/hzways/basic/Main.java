package com.hzways.basic;

import java.lang.reflect.Type;

/**
 * desc: Main
 *
 * @author hz.lei
 * @since 2018年07月30日 下午9:22
 */
public class Main<T> {
    private Boolean flag;


    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> flag = Main.class.getDeclaredField("date").getType();
        Type flag1 = Main.class.getDeclaredField("date").getGenericType();
        System.out.println(flag.toString());
        System.out.println(flag1.toString());
    }
}

