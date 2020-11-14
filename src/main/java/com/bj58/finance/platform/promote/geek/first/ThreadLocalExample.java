package com.bj58.finance.platform.promote.geek.first;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  ThreadLocal
 * */
public class ThreadLocalExample {

    private static final ThreadLocal<String> currentUser = ThreadLocal.withInitial(() -> null);

    public static void main(String[] args) {

        //定义一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,1,10l,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

        for(int i = 0; i < 5; i++){
            threadPool.execute(new Thread(()->{
                try{
                    String before = currentUser.get();
                    System.out.println(Thread.currentThread().getName() + "+" + before);
                    currentUser.set("liuyc" + Math.random() );
                    String curr = currentUser.get();
                    System.out.println(Thread.currentThread().getName() + "+" + curr);
                }finally{
                    //显式移除
                    currentUser.remove();
                }
            },"thread-" + i));
        }
        threadPool.shutdown();
        while(!threadPool.isTerminated()){
        }
    }

}
