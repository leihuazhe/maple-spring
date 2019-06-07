package com.hzways.spring.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author maple 2018.09.23 下午3:00
 */
public class MapleFactoryBean<T> implements FactoryBean<T> {
    private static Logger logger = LoggerFactory.getLogger(MapleFactoryBean.class);
    private Class<T> beanClass;
    private String beanName;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public MapleFactoryBean(Class<T> beanClass) {
        this.beanClass = beanClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getObject() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanClass);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, methodProxy) -> {
            logger.info("call bean:{} before,argument {}  ", beanName, args);
            //调用父类的方法
            Object result = methodProxy.invokeSuper(obj, args);
            logger.info("call bean:{} after ,result ==> [{}]  ", beanName, result);
            return result;
        });
        return (T) enhancer.create();
    }

    @Override
    public Class<?> getObjectType() {
        return beanClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
