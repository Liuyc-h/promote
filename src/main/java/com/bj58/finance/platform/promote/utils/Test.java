package com.bj58.finance.platform.promote.utils;


import com.alibaba.fastjson.JSONObject;

public class Test {

    public int[] mergeTwoArray(int[] array1,int[] array2){

        if(array1 == null || array1.length == 0){
            return array2;
        }
        if(array2 == null || array2.length == 0){
            return array1;
        }
        int length1 = array1.length;
        int length2 = array2.length;
        //结果数组
        int[] result = new int[length1 + length2];
        //结果数组的滑动索引
        int resultIndex = 0;
        //array1的滑动
        int slideIndex1 = 0;
        //array2的滑动
        int slideIndex2 = 0;

        while(slideIndex1 < length1 || slideIndex2 < length2){
            //array1已经放完了，array2还没放完
            if(slideIndex1 >= length1){
                result[resultIndex ++] = array2[slideIndex2 ++];
                continue;
            }
            //array2已经放完了，array1还没放完
            if(slideIndex2 >= length2){
                result[resultIndex ++] = array1[slideIndex1 ++];
                continue;
            }
            if(array1[slideIndex1] <= array2[slideIndex2]){
                result[resultIndex++] = array1[slideIndex1 ++];
            }else{
                result[resultIndex ++] = array2[slideIndex2 ++];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] array1 = new int[]{1,3,5,7,9};
        int[] array2 = new int[]{2,4,6,8,10};

        System.out.println(JSONObject.toJSONString(new Test().mergeTwoArray(array1,array2)));


    }
}
