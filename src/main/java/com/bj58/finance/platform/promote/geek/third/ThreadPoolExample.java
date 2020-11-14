package com.bj58.finance.platform.promote.geek.third;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class ThreadPoolExample {

    /**
     *  线程池 先创建核心线程，核心线程满了后进入阻塞队列，阻塞队列满了后创建非核心线程，到达
     *  最大线程数后，就是拒绝策略，分为4个，@1.丢弃任务，并抛出异常；@2.丢弃任务；
     *  --@3.由调用者线程去处理；@4.丢弃队列最前面的任务，提交拒绝任务。
     * **/
    public static void main(String[] args) {

        String payload = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> "a")
                .collect(Collectors.joining("-")) + UUID.randomUUID().toString();

        System.out.println(payload);

    }



    public void oom1() throws InterruptedException {

        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        ThreadPoolExecutor threadPool1 = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //回收核心线程
        threadPool.allowCoreThreadTimeOut(true);
        //启动所有核心线程
        threadPool.prestartAllCoreThreads();
        //打印线程池的信息
        printStats(threadPool);
        for (int i = 0; i < 100000000; i++) {
            threadPool.execute(() -> {
                String payload = IntStream.rangeClosed(1, 1000000)
                        .mapToObj(j -> "a")
                        .collect(Collectors.joining("")) + UUID.randomUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                }
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }



    private void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());

            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
