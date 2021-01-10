//package com.bj58.finance.platform.promote.jvm.over;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
//public class Demo1 {
//
//    public static void main(String[] args) {
//
//        while(true){
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(Car.class);
//            enhancer.setUseCache(false);
//
//            enhancer.setCallback(new MethodInterceptor() {
//                @Override
//                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                    if(method.getName().equals("run")){
//                        System.out.println("启动汽车之前，先进行自动的安全检查。。。。。。。。");
//                        return methodProxy.invoke(o,objects);
//                    }else{
//                        return methodProxy.invoke(o,objects);
//                    }
//                }
//            });
//
//            Car car = (Car) enhancer.create();
//            car.run();
//        }
//    }
//}
