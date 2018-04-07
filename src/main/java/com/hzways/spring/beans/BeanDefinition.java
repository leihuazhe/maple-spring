package com.hzways.spring.beans;

/**
 * 描述:
 *
 * @author hz.lei
 * @date 2018年04月07日 下午2:09
 */
public class BeanDefinition {
    /**
     * bean 实例
     */
    private Object bean;
    /**
     * bean class
     */
    private Class beanClass;
    /**
     * bean className 暂时没用到...
     */
    private String beanClassName;


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
