package com.bj58.finance.platform.promote.tuling.concurr;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {

    /**
     *  Synchronized  关键字，内置锁，隐式的
     *  ReentrantLock 显式锁
     *
     *  加锁：
     *     1、静态方法 -- 此时加在 class对象上面，此时都活竞争
     *        非静态方法  -- 此时加在new的对象上面，两个对象的锁不冲突
     *     2、方法块里面
     *        静态类
     *        非静态类
     *
     *        Epoch    ThreadId age  偏向状态（0/1） 锁状态标志
     *
     *   无锁    对象的hashcode值（25bit）  分代年龄（4bit） 是否偏向锁（0 1bit） 锁标志位（01）2bit
     *   轻量级锁 指向栈中所记录的指针（30bit）   锁标志位（2bit）00
     *   重量级锁 指向互斥量的指针（30bit）      锁标志位（2bit） 10
     *
     *   偏向锁   线程id（23bit） Epoch（2bit） 分代年龄（4bit） 是否偏向锁1（1bit） 锁标志位（01）2bit
     *
     *
     *   偏向锁 ，jvm会延迟开启偏向锁，大概是4s，jvm启动的时候，内部有竞争，为了减少内部锁升级的消耗，所以会延迟启动
     *   锁升级过程：
     *      初始是处于无锁状态，
     *      偏向锁开启后，会处于匿名偏向，即可偏向状态，此时还没线程进来
     *      当线程进来后，会偏向于这个线程
     *      如果有其他线程来竞争，锁会升级为轻量级锁（调用hashcode方法也会导致升级为轻量级锁）
     *      当线程自旋获取轻量级锁失败后，锁会膨胀为重量级锁（自旋次数可配置）
     *
     *      锁可升级，但不可降级；
     *
     *      轻量级锁   hashcode记载在lock record里面
     *      重量级锁   hashcode记载在monitor里面
     *
     *
     *
     * **/
    public static void main(String[] args) {



    }
}
