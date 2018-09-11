package com.hzways.post.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author maple 2018.09.10 下午10:29
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyInstantiationAwareBeanPostProcessor.class);

    /**
     * (1)
     * bean 还没实例化之前的操作...
     * 返回了对象
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.print("beanName:" + beanName + "执行..postProcessBeforeInstantiation\n");
        //利用 其 生成动态代理
        if (beanClass == HelloWorld.class) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);

            enhancer.setCallback(new HelloMethodInterceptor());
            HelloWorld helloWorld = (HelloWorld) enhancer.create();
            LOGGER.info("返回动态代理对象HelloWorld proxy");
            return helloWorld;
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        LOGGER.info("beanName:" + beanName + "执行..postProcessAfterInstantiation\n");
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        LOGGER.info("beanName:" + beanName + "执行..postProcessPropertyValues\n");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("beanName:" + beanName + "执行..postProcessBeforeInitialization\n");

        return bean;
    }

    /**
     * (2)
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("beanName:" + beanName + "执行..postProcessAfterInitialization\n");

        return bean;
    }
}
