package com.bj58.finance.platform.promote.algorithm.daily.array;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution922 {

    public int[] sortArrayByParityII(int[] A) {

        int length = A.length;

        int[] arrayQ = new int[length / 2];
        int[] arrayO = new int[length / 2];

        int indexQ = 0;
        int indexO = 0;
        for(int i =0; i < length; i++){
            if(A[i] % 2 == 0){
                arrayO[indexO ++] = A[i];
            }else{
                arrayQ[indexQ ++] = A[i];
            }
        }
        int[] resultArray = new int[length];
        int index1Q = 0;
        int index1O = 0;
        for(int i = 0; i < length; i++){
            if(i % 2 == 0){
                resultArray[i] = arrayO[index1O ++];
            }else{
                resultArray[i] = arrayQ[index1Q ++];
            }
        }
        return resultArray;
    }


    public int[] sortArrayByParityII1(int[] A) {

        int length = A.length;

        for(int i = 0; i < length - 1; i++){
            int data = A[i];
            if( i % 2 == data % 2){
                continue;
            }
            for(int j = i + 1; j < length; j++){
                if(data % 2 == A[j] % 2){
                    continue;
                }
                A[i] = A[j];
                A[j] = data;
                break;
            }
        }
        return A;
    }

    public int[] sortArrayByParityII2(int[] A) {

        int length = A.length;

        int[] resultArray = new int[length];
        int indexQ = 1;
        int indexO = 0;

        for(int i = 0; i < length; i++){
            if(A[i] % 2 == 0 ){
                resultArray[indexO ]= A[i];
                indexO = indexO + 2;
            }else{
                resultArray[indexQ ]= A[i];
                indexQ = indexQ + 2;
            }
        }
        return resultArray;
    }

}
