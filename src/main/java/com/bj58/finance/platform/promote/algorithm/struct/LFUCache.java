package com.bj58.finance.platform.promote.algorithm.struct;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    //从key-value的映射
    private Map<Integer,Integer> kTovMap;
    //从key - freq 的映射
    private Map<Integer,Integer> kToFMap;
    //从freq - key的映射
    private Map<Integer, LinkedHashSet<Integer>> fToKeyMap;
    //容量
    private int capicaty;
    //最小访问次数
    private int minFreq;

    public LFUCache(int capacity) {
        this.capicaty = capacity;
        this.kTovMap = new HashMap<>();
        this.kToFMap = new HashMap<>();
        this.fToKeyMap = new HashMap<>();
        this.minFreq = 0;
    }

    public int get(int key) {

        if(!kTovMap.containsKey(key)){
            return -1;
        }
        int value = kTovMap.get(key);
        //执行访问次数加1的操作
        increaseFreq(key);
        return value;
    }

    public void put(int key, int value) {
        if(capicaty == 0){
            return;
        }
        //如果已经存在，直接更新即可
        if(kTovMap.containsKey(key)){
            kTovMap.put(key,value);
            increaseFreq(key);
            return;
        }
        //如果当前的size小于容量，则直接加就行
        if(kTovMap.size() < capicaty){
            // key - value 里面赋值
            kTovMap.put(key,value);
            //key - freq 里面赋值
            kToFMap.put(key,1);
            //取出当前访问量为1的key的集合
            LinkedHashSet<Integer> keySet = fToKeyMap.getOrDefault(1,new LinkedHashSet<>());
            keySet.add(key);
            fToKeyMap.put(1,keySet);
            //最小访问量直接赋为1即可
            minFreq = 1;
            return;
        }
        //下面就该先删除访问次数最小的一个元素
        LinkedHashSet<Integer> keySet = fToKeyMap.get(minFreq);
        //最老的一个key,删除
        int oldestKey = keySet.iterator().next();
        keySet.remove(oldestKey);
        if(keySet.isEmpty()){
            fToKeyMap.remove(minFreq);
        }
        kTovMap.remove(oldestKey);
        kToFMap.remove(oldestKey);

        minFreq = 1;
        // key - value 里面赋值
        kTovMap.put(key,value);
        //key - freq 里面赋值
        kToFMap.put(key,1);
        //取出当前访问量为1的key的集合
        LinkedHashSet<Integer> oneKeySet = fToKeyMap.getOrDefault(1,new LinkedHashSet<>());
        oneKeySet.add(key);
        fToKeyMap.put(1,oneKeySet);
    }

    //对key，访问一次增加一次，增加访问次数不需要进行元素是否超出容量
    private void increaseFreq(int key){
        //先找出当前的频率
        int freq = kToFMap.get(key);
        //找出当前的freq的key集合
        LinkedHashSet<Integer> keySet = fToKeyMap.get(freq);
        //访问频率加一
        int incrFreq = freq + 1;
        //下一个的key集合
        LinkedHashSet<Integer> keySetNext = fToKeyMap.getOrDefault(incrFreq,new LinkedHashSet<>());
        //增加或者删除key
        keySetNext.add(key);
        keySet.remove(key);
        //更新key - freq的映射
        kToFMap.remove(key);
        kToFMap.put(key,incrFreq);
        fToKeyMap.put(incrFreq,keySetNext);
        //如果原来的set集合已经空了，则删除
        if(keySet.isEmpty()){
            fToKeyMap.remove(freq);
            //如果freq恰好等于minFreq，则加一
            if(freq == minFreq){
                minFreq ++;
            }
        }
    }

    public static void main(String[] args) {
        // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
        LFUCache lFUCache = new LFUCache(3);
        lFUCache.put(2, 2);   // cache=[1,_], cnt(1)=1
        lFUCache.put(1, 1);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lFUCache.get(2);      // 返回 1
        lFUCache.get(1);
        lFUCache.get(2);
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        lFUCache.put(4, 4);
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lFUCache.get(3);      // 返回 -1（未找到）
        lFUCache.get(2);      // 返回 3
        lFUCache.get(1);
        lFUCache.get(4);


    }
}
