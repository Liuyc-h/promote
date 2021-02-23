package com.bj58.finance.platform.promote.tuling.concurr.wait;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/***
 *  控制访问特定资源的线程数目,底层依赖AQS的状态state,限流可以用
 *
 *
 * **/
public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(10);

        semaphore.acquireUninterruptibly();


        CountDownLatch count = new CountDownLatch(10);

        count.countDown();

    }
}
