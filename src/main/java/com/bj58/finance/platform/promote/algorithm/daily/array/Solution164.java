package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.*;

/**
 *  给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution164 {

    public int maximumGap(int[] nums) {

        if(nums == null || nums.length <= 1){
            return 0;
        }
        //数组中的最小数
        int minData = 0;
        //数组中的最大数
        int maxData = 0;
        for(int i =0; i< nums.length; i++){
            minData = Math.min(minData,nums[i]);
            maxData = Math.max(maxData,nums[i]);
        }
        //计算桶的数量
        int length = maxData - minData + 1;
        int[] indexResult = new int[length];
        for(int i = 0; i< nums.length; i++){
            int index = nums[i] - minData;
            indexResult[index] ++;
        }
        //排序后的数组集合
        int[] sortArray = new int[nums.length];
        int index = 0;
        for(int i =0; i < indexResult.length; i++){
            int count = indexResult[i];
            for(int j =0; j < count; j++ ){
                sortArray[index ++] = i + minData;
            }
        }

        int maxSpace = 0;

        for(int i = 1; i< sortArray.length; i++){
            maxSpace = Math.max(maxSpace,sortArray[i] - sortArray[i - 1]);
        }
        return maxSpace;
    }
    public static void main(String[] args) {


        int[] nums = new int[]{3,6,9,1};

        System.out.println(new Solution164().maximumGap1(nums));

    }
    /***
     *
     *  桶排序
     * **/
    public int maximumGap1(int[] nums) {

        if(nums == null || nums.length <= 1){
            return 0;
        }
        //数组中的最小数
        int minData = 0;
        //数组中的最大数
        int maxData = 0;
        for(int i =0; i< nums.length; i++){
            minData = Math.min(minData,nums[i]);
            maxData = Math.max(maxData,nums[i]);
        }
        if(minData == maxData){
            return 0;
        }
        //桶的个数
        int length = nums.length;
        //两数的差值
        int dataDiff = maxData - minData;
        //每两个之间的差异
        int distance = dataDiff / length + 1;
        List<PriorityQueue<Integer>> listArray = new ArrayList<>();
        for(int i = 0; i< length; i++){
            listArray.add(new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }));
        }
        for(int i =0; i < length; i++){
            int index = (nums[i] - minData) / distance;
            listArray.get(index).offer(nums[i]);
        }

        int[] resultArray = new int[length];
        int index = 0;
        for(int i =0 ; i< length; i++){
            PriorityQueue<Integer> priorityQueue = listArray.get(i);
            while(!priorityQueue.isEmpty()){
                resultArray[index ++] = priorityQueue.poll();
            }
        }
        int maxSpace = 0;
        for(int i = 1; i< resultArray.length; i++){
            maxSpace = Math.max(maxSpace,resultArray[i] - resultArray[i - 1]);
        }
        return maxSpace;
    }

    /**
     *  直接ArraySort排序
     * **/
    public int maximumGap2(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        Arrays.sort(nums);
        int maxSpace = 0;

        for(int i = 1; i< nums.length; i++){
            maxSpace = Math.max(maxSpace,nums[i] - nums[i - 1]);
        }
        return maxSpace;
    }


    /***
     *  基于桶内的数据的差值肯定不会大于桶之间的差值，维护每个桶的最大值和最小值
     * **/
    public int maximumGap5(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        //数组中的最小值
        int minVal = Arrays.stream(nums).min().getAsInt();
        //数组中的最大值
        int maxVal = Arrays.stream(nums).max().getAsInt();
        //桶间距
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        //桶的个数
        int bucketSize = (maxVal - minVal) / d + 1;

        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            Arrays.fill(bucket[i], -1); // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minVal) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }

        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
    /**
     *  基于基数排序
     * **/
    public int maximumGap6(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
