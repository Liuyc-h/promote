package com.bj58.finance.platform.promote.algorithm.sort;

/**
 *  直接排序
 * **/
public class DirectSort {

    //插入排序
    public void sort(int[] array){

        int length = array.length;

        for(int i =1; i< length ; i++){
            for(int j = i; j> 0; j--){
                if(j > 0 && array[j] < array[j-1] ){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
