package com.bj58.finance.platform.promote.geek.first;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Slf4j
public class ConcurrentHashMapExample {

    private static Object object = new Object();

    private static int THREAD_COUNT = 10;

    private static int ITEM_COUNT = 1000;

    //帮助方法，用来获得一个指定元素数量模拟数据的
    private static ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    /**
     *  补充元素
     * **/
    private static void genData() throws Exception{
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);

        System.out.println("初始" + concurrentHashMap.size() + "个元素");

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        //使用线程池并发处理逻辑
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {

            synchronized (object){
                //查询还需要补充多少个元
                int gap = ITEM_COUNT - concurrentHashMap.size();

                log.info("还需要补充" + gap + "个元素");
                System.out.println("还需要补充" + gap + "个元素");
                //补充元素
                concurrentHashMap.putAll(getData(gap));
            }
        }));
        //等待所有任务完成
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("最终" + concurrentHashMap.size() + "个元素");

        System.out.println(concurrentHashMap);
    }

    /**
     *  统计key的数量
     * */
    private static void normaluse() throws Exception{
        //循环数量
        int LOOP_COUNT = 10000000;
        //
        ConcurrentHashMap<String, Long> freqs = new ConcurrentHashMap<>(ITEM_COUNT);

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);

        forkJoinPool.execute(()->{
            IntStream.rangeClosed(0,LOOP_COUNT).parallel().forEach(i -> {
                //获得一个随机的key
                String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);

                synchronized (object){
                    Long size = freqs.getOrDefault(key,0l);
                    freqs.put(key,size + 1);
                }
            });
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    }

    /**
     *  统计key的数量
     * */
    private static void normaluseLongAddr() throws Exception{
        //循环数量
        int LOOP_COUNT = 10000000;
        //
        ConcurrentHashMap<String, LongAdder> freqs = new ConcurrentHashMap<>(ITEM_COUNT);

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);

        forkJoinPool.execute(()->{
            IntStream.rangeClosed(0,LOOP_COUNT).parallel().forEach(i -> {
                //获得一个随机的key
                String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
                //原子操作
                freqs.computeIfAbsent(key,k->new LongAdder()).increment();

//                freqs.putIfAbsent()
                Map<String,String> map = new HashMap<>();
                // value是一个Function接口，value ！= null
                //如果map.get(key)有值，则返回旧值
                //如果没值，则进行put操作并返回value.apply()
                map.computeIfAbsent(key,k -> "liuyc");
                //value值就是map里面得value，
                //如果map.get(key)有值，返回旧值
                //如果map.get(key)没有值，则进行put操作，返回null
                map.putIfAbsent(key,"liuyc");

            });
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    }

    public static void main(String[] args) throws Exception {

        genData();



    }


}
