package com.bj58.finance.platform.promote.tuling.pool;

import java.util.concurrent.*;

/**
 *  线程池
 *
 *  1、创建线程的方法
 *     a、继承Thread
 *     b、实现Runable接口
 *     c、实现Callable接口
 *   2、线程池的参数
 *     corePoolSize  核心线程数
 *     maximumPoolSize  线程池允许的最大线程数
 *     keepAliveTime  允许线程不干活的时间
 *     unit          时间单位
 *     workQueue  存放未执行任务的队列
 *     handler   拒绝策略
 *           AbortPolicy  抛异常
 *           CallerRunsPolicy 当前调用者线程进行处理
 *           DiscardPolicy  丢弃任务，不做任何处理
 *           DiscardOldestPolicy 丢弃队列中最早的线程
 *    3、位运算
 *       <<  左移，不管正负，低位补0
 *       >>  右移 ，正数高位补0，负数高位补1
 *       >>> 右移， 不管正负，高位补0
 *    3、线程池的
 *
 * **/
public class ThreadPoolTest {


    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,10,60l,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(16));

        for(int i = 0; i < 20; i ++){
            int j  = i;

//            poolExecutor.submit()
            Future<String> future = poolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("第" + j + "个线程");
                    return Thread.currentThread().getName();
                }
            } );

            Future<String> future1 = poolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + j + "个线程");
                }
            },"success");
            System.out.println();
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


        poolExecutor.shutdownNow();
        while(!poolExecutor.isTerminated()){
            System.out.println("线程还未执行完成");
        }

//        System.out.println(poolExecutor.);



    }
}
