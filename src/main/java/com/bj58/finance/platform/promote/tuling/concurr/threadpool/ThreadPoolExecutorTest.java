package com.bj58.finance.platform.promote.tuling.concurr.threadpool;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/***
 *  线程池
 *
 * ***/
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,60l, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        List<Future<String>> str = new ArrayList<>();

        for(int i = 0; i < 10; i ++){

            Future<String> future = threadPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "liuyc";
                }
            });
        }
    }
}
