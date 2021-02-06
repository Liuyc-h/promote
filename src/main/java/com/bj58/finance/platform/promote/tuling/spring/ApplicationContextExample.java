package com.bj58.finance.platform.promote.tuling.spring;

import com.bj58.finance.platform.promote.config.JavaConfig;
import org.springframework.beans.BeansException;
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
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextExample {

    public static void main(String[] args) {

//        ClassPathResource resource = new ClassPathResource("bean.xml"); // <1>

//        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(JavaConfig.class);

//        ConfigurationClassPostProcessor
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // <2>

//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // <3>

//        reader.loadBeanDefinitions(resource);

//        BeanPostProcessor beanPostProcessor = new BeanPostProcessor() {
//            @Override
//            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//                return null;
//            }
//
//            @Override
//            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//                return null;
//            }
//        };



//        ApplicationContext context1 = new AnnotationConfigApplicationContext();
//        InstantiationAwareBeanPostProcessor

//        BeanFactory
//        FactoryBean

//        BeanDefinitionR

    }
}
