package com.github.maple;

import jdk.internal.misc.Unsafe;

/**
 * --add-exports java.base/jdk.internal.misc=ALL-UNNAMED
 *
 * @author maple 2018.09.26 下午8:15
 */
public class UnsafeTest {

    public static void main(String[] args) {
        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.getByte(10);
        System.out.println(unsafe);
    }

}
