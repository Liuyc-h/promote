package com.bj58.finance.platform.promote.tuling.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextExample {

    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("bean.xml"); // <1>

        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // <2>

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // <3>

        reader.loadBeanDefinitions(resource);



//        ApplicationContext context1 = new AnnotationConfigApplicationContext();
//        InstantiationAwareBeanPostProcessor

//        BeanFactory
//        FactoryBean

//        BeanDefinitionR

    }
}
