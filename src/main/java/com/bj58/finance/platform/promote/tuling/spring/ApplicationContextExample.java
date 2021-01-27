package com.bj58.finance.platform.promote.tuling.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExample {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext();

        ApplicationContext context1 = new AnnotationConfigApplicationContext();

//        InstantiationAwareBeanPostProcessor

//        BeanFactory
//        FactoryBean

//        BeanDefinitionR
    }
}
