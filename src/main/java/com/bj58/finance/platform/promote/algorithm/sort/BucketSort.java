package com.bj58.finance.platform.promote.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

/**
 *  桶排序
 * **/
public class BucketSort {
    /**
     * 空间可能浪费很大
     * **/
    public int[] sort(int[] nums){
        //数组中的最小数
        int minData = 0;
        //数组中的最大数
        int maxData = 0;
        for(int i =0; i< nums.length; i++){
            minData = Math.min(minData,nums[i]);
            maxData = Math.max(maxData,nums[i]);
        }
        //最大最小相等不用转换了
        if(minData ==  maxData){
            return nums;
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
        return sortArray;
    }


    public static void main(String[] args) {
        int[] array = new int[]{7,6,8,2,3,5,6};
        int[] resultArray = new BucketSort().sort(array);
        System.out.println(JSONObject.toJSONString(resultArray));
    }
}
