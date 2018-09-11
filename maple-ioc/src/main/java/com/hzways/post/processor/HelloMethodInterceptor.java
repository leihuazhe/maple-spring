package com.hzways.post.processor;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author maple 2018.09.10 下午10:28
 */
public class HelloMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("目标方法前:" + method + "\n");

        Object object = methodProxy.invokeSuper(obj, objects);

        System.out.println("目标方法后:" + method + "\n");
        return object;
    }
}
