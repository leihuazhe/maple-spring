package com.hzways.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author maple 2018.09.23 下午1:12
 */
public class BeanScannerRegistry implements BeanFactoryPostProcessor, ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(BeanScannerRegistry.class);
    private String basePackage;
    private ApplicationContext applicationContext;

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("beanFactory: " + beanFactory);
        MapleScanner scanner = new MapleScanner((BeanDefinitionRegistry) beanFactory);
        scanner.setResourceLoader(this.applicationContext);
        scanner.setAnnotationClass(Maple.class);
        scanner.registerFilters();
        scanner.scan(basePackage);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("applicationContext: " + applicationContext);
        this.applicationContext = applicationContext;
    }
}
