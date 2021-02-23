package com.bj58.finance.platform.promote.tuling.concurr.wait;

import java.util.concurrent.CountDownLatch;

public class CountDownLaunchRunner {

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new SeeDoctorTask(countDownLatch)).start();
        new Thread(new QueueTask(countDownLatch)).start();
        //等待线程池中的2个任务执行完毕，否则一直
        countDownLatch.await();
        System.out.println("over，回家 cost:" + (System.currentTimeMillis() - now));
    }
}
