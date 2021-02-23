package com.bj58.finance.platform.promote.tuling.concurr.wait;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTest {


    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch =  new CountDownLatch(3);

        for(int i = 0; i < 3; i++){

            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + j + "个线程");
                    countDownLatch.countDown();
                }
            },"Thread- " + i).start();
        }


        countDownLatch.await();

        System.out.println("线程全部执行");
    }
}
