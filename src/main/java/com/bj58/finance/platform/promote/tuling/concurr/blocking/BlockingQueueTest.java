package com.bj58.finance.platform.promote.tuling.concurr.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/***
 * 线程通信得一个工具，在任意时刻，不管并发有多高，在单机jvm，同一时间永远只有一个线程能够对队列进行入队或者出队操作。
 *   1、线程安全得队列
 * 应用场景
 *       线程池，Eureka的三级缓存，Nacos，Netty，MQ
 *
 * put   ---添加元素，如果队列满了，则等待，aqs的等待队列
 * add   ---添加元素，如果队列满了，抛出异常
 * offer ---添加成功返回true，失败返回false
 * take  ---返回头节点，并删除，如果没有，则等待
 * poll  ---返回头节点，如果没有返回null，有则返回
 *
 * 线程获取锁的条件是：CLH队列的前驱节点是single
 *   条件等待队列是不能获取锁的
 *
 *
 *
 * **/
public class BlockingQueueTest {


    public static void main(String[] args) {
        //队列容量
        int BOUND = 10;
        //生产者的数量
        int N_PRODUCERS = 16;
        //cpu核数
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        int poisonPill = Integer.MAX_VALUE;

        //次数
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);
        //潘金莲给武大郎熬药
        for (int i = 1; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }
        //武大郎开始喝药
        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //潘金莲开始投毒，武大郎喝完毒药GG
        new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();
    }
}
