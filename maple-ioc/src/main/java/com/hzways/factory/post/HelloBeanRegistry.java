package com.hzways.factory.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author maple 2018.09.22 下午10:38
 */
@Component
public class HelloBeanRegistry implements BeanDefinitionRegistryPostProcessor {
    private Logger logger = LoggerFactory.getLogger(HelloBeanRegistry.class);

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        logger.info("postProcessBeanDefinitionRegistry call ");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("postProcessBeanFactory ready to call");
    }
}
