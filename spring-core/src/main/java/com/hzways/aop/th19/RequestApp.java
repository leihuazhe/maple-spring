package com.hzways.aop.th19;

import net.sf.cglib.proxy.Enhancer;

public class RequestApp {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(RequestImpl.class);
        enhancer.setCallback(new RequestCtrlCallback());

        RequestImpl proxy = (RequestImpl) enhancer.create();

        proxy.request();
    }
}
