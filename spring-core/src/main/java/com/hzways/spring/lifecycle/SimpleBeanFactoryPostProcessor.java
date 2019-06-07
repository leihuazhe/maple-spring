package com.hzways.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * desc: 生命周期
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:18
 */
//@Component
public class SimpleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public SimpleBeanFactoryPostProcessor() {
        System.out.println("SimpleBeanFactoryPostProcessor");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("beanFactory" + beanFactory.toString());

    }
}