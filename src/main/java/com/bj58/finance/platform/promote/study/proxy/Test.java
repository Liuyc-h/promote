package com.bj58.finance.platform.promote.study.proxy;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {




        UserServiceImpl userService = new UserServiceImpl();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(userService);

        factory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println(method.getName() + "方法返回");
            }
        });
        factory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println(method.getName() + "方法开始");
            }
        });

        UserService proxy = (UserService) factory.getProxy();

//        UserService userService1 = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),
//                UserServiceImpl.class.getInterfaces(), new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                        System.out.println("代理逻辑");
//                        Object result = method.invoke(userService,args);
//                        return result;
//                    }
//                });
        proxy.test();



    }
}
