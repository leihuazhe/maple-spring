package com.hzways.aop.th19;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class RequestCtrlCallback implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("request")) {
            LocalDateTime now = LocalDateTime.now();

            if (now.getHour() < 23) {
                System.out.println("RequestCtrlCallback");
                return methodProxy.invokeSuper(obj, args);
            }
        }
        return null;
    }
}
