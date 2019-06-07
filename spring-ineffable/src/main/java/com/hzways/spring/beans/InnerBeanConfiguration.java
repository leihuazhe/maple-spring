package com.hzways.spring.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * desc: TODO
 *
 * @author hz.lei
 * @since 2018年05月30日 上午12:36
 */
@Configuration
public class InnerBeanConfiguration {


    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public HelloProcessor getHelloProcessor() {
        return new HelloProcessor();
    }

}
