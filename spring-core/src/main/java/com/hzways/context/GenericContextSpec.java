package com.hzways.context;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class GenericContextSpec {

    public static void main(String[] args) {
        //Build applicationContext
        GenericApplicationContext context = new GenericApplicationContext();
        //BeanDefinition Reader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        //Load xml file
        reader.loadBeanDefinitions(new ClassPathResource("generic-context.xml"));
        //Refresh
        context.refresh();
        //Get bean
        Printer printer = context.getBean(Printer.class);

        System.out.println(printer.printName());

        //Close applicationContext
        context.close();
    }
}
