package com.bj58.finance.platform.promote.tuling.collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/***
 *
 * HashMap底层的数据结构
 *      数组 + 链表 + 红黑树 （java8）
 *
 *      红黑树的五个特征：
 *        1、根节点是黑色的；
 *        2、每个节点要么是红的，要么是黑的；
 *        3、每个叶节点（树尾端的NIL指针或者NULL节点）都是黑的；
 *        4、如果一个节点是红的，那么它的两个儿子都是黑的；
 *        5、对于任意节点而言，其到叶节点树尾端NIL指针的每条路径都包含相同数目的黑节点。
 *
 *  1、负载因子为什么是0.75
 *     0.75是基于空间和时间的考虑
 *        如果大于1，则哈希碰撞的几率会升高，造成链表过长，遍历时间增长
 *        如果小于0.5，则哈希碰撞的概率会降低，但是空间利用率会下降
 *     同时基于数学公式 牛顿二项式（泊松分布），折中取值为0.75
 *
 *
 *
 *  2、数组长度为什么是2的幂次方
 *    @1、我们需要根据hashCode值取进行获取数组的下标，通过length-1（所有的位都是1）&hashcode，保证所有的值都落在length范围内
 *    @2、传统的取模运算效率太低，位运算是效率最高的；
 *    @3、扩容的时候，1.8的扩容是拿扩容前的length的二进制数去和hashCode做与运算的，如果为1则需要迁移，为0则不需要迁移。
 *
 *  3、为什么转换为红黑树的阈值是8
 *     我认为hashMap是尽量避免链表转化为红黑树的，从hash表的长度小于64的情况下即便链表长度大于8也不会转换为红黑树来看。
 *     从源码注释上看，当负载因子为0.75的时候，链表的长度是遵循泊松分布的，当链表的长度为8的时候的概率几乎为0，所以定义为8
 *     根据概率统计
 *
 *
 *  A、HashMap的底层数据结构
 *     1.7 -- 数组 + 链表
 *            1.7的链表插入是头部插入
 *     1.8 -- 数组 + 链表 + 红黑树
 *  B、重要成员变量
 *     DEFAULT_INITIAL_CAPACITY = 1 << 4 默认初始容量
 *     MAXIMUM_CAPACITY = 1 << 30   数组的最大长度
 *     DEFAULT_LOAD_FACTOR = 0.75f   负载因子
 *     TREEIFY_THRESHOLD = 8   链表转换为红黑树的阈值
 *     UNTREEIFY_THRESHOLD = 6  红黑树回转为链表的阈值
 *     MIN_TREEIFY_CAPACITY = 64  转换为红黑树的数组容量阈值
 *  C、扩容的条件
 *     1.7  element.size() >  threshold的时候且put的时候当前桶不为空
 *     1.8  1、element.size() >  threshold的时候
 *          2、链表数量超过8，但容量低于64
 *
 *
 * **/
public class HashMapTest {


    public static void main(String[] args) {

        HashMap<String,String> map = new HashMap<>(13);

        map.put("liuyc","liuyc2");

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put()



    }
}
