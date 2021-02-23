package com.bj58.finance.platform.promote.tuling.concurr;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  lock实现得四大核心：
 *     自旋；
 *     LockSupport；
 *     CAS---Compare and  Swap
 *     队列 --- 保存阻塞得线程
 *
 *  AQS
 *     阻塞等待队列；
 *     共享/独占；
 *     公平/非公平；
 *     可重入；
 *     允许中断；
 *
 *
 *     waitStatus 当前节点的生命状态，信号量
 *          CANCELLED = 1 ----- 因为异常或者中断引起的，要被废除
 *          SINGLE = -1    ----- 可被唤醒
 *          CONDITION = -2 -----条件等待
 *          PROPAGATE = -3  ----传播
 *          0
 *      唤醒的方式：
 *          1、中断
 *          2、release
 *
 *       中断存在得意义：
 *          一种优雅无伤得方式去终结线程得处理方式。
 *
 *
 *
 *
 *
 * **/
public class LockExample {


    public static void main(String[] args) {



        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread currThread = Thread.currentThread();
                System.out.println("准备开始执行!" + currThread.getName());

                for(;;){
                    System.out.println("准备park住当前线程" + currThread.getName());
                    LockSupport.park();
                    System.out.println("当前线程" + currThread.getName() + "已被唤醒");
                }
            }
        },"t0");
        t0.yield();
        t0.start();

        try{

//            for(;;){
                Thread.sleep(5000);
                System.out.println("准备唤醒线程" + t0.getName());
                LockSupport.unpark(t0);

                Thread.sleep(2000);
                t0.interrupt();
//            }

        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//
//        ReentrantLock lock = new ReentrantLock(true);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                lock.lock();
//                try{
//                    Thread.sleep(5000);
//                }catch(Exception e){
//                    e.printStackTrace();
//                }finally {
//                    lock.unlock();
//                }
//
//            }
//        },"t0").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lock.lock();
//                try{
//                    Thread.sleep(500000);
//                }catch(Exception e){
//                    e.printStackTrace();
//                }finally {
//                    lock.unlock();
//                }
//            }
//        },"t1").start();
//
//
//
//
//    }


//    public static void main(String[] args) {
//
//
//        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
//
//        BlockingQueue<String> blockingQueue1 = new LinkedBlockingDeque<>();;
//
//        blockingQueue.add("liuyc");
//
//
//
//    }



}
