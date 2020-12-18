package com.bj58.finance.platform.promote.algorithm.classification.计数排序;

/**
 *  给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution1122 {
    /**
     *  计数排序
     *
     *  先找出数据中的最大值max，以构建一个max + 1 的数组array
     *
     *  遍历arra1，以arr1[i] 为array的索引下标，统计该数据出现的次数
     *
     *  然后遍历arr2,以arr2的顺序开始构造结果数组
     *  没有在arr2中出现的数据正好可以根据数组来进行排序
     * **/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int maxInt = 0;
        //先找出最大值
        for(int i = 0; i< arr1.length; i++){
            maxInt = Math.max(arr1[i],maxInt);
        }
        int[] indexArray = new int[maxInt + 1];
        for(int data: arr1){
             ++ indexArray[data];
        }
        int[] resultArray = new int[arr1.length];
        int index = 0;
        for(int data : arr2){
            for(int i = 0 ; i< indexArray[data]; i++ ){
                resultArray[index++] = data;
            }
            indexArray[data] = 0;
        }

        for(int j = 0; j < indexArray.length; j++){
            for(int i = 0 ; i< indexArray[j]; i++ ){
                resultArray[index++] = j;
            }
        }
        return resultArray;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {

        int[] indexArray = new int[1001];
        for(int data: arr1){
            ++ indexArray[data];
        }
        int[] resultArray = new int[arr1.length];
        int index = 0;
        for(int data : arr2){
            for(int i = 0 ; i< indexArray[data]; i++ ){
                resultArray[index++] = data;
            }
            indexArray[data] = 0;
        }

        for(int j = 0; j < indexArray.length; j++){
            for(int i = 0 ; i< indexArray[j]; i++ ){
                resultArray[index++] = j;
            }
        }
        return resultArray;
    }
}
