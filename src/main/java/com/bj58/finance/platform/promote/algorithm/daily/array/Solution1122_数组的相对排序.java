package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 给你两个数组，arr1 和 arr2，
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
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution1122_数组的相对排序 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] array = new int[1001];
        for(int i = 0 ; i < arr1.length ;i++){
            array[arr1[i]] ++;
        }
        int[] resultArray = new int[arr1.length];
        int index = 0;
        for(int i = 0; i< arr2.length; i++){
           int count = array[arr2[i]];
           for(int j = 0; j < count; j++){
               resultArray[index ++] = arr2[i];
           }
            array[arr2[i]] = 0;
        }

        for(int i =0; i < array.length; i++){
            int count = array[i];
            for(int j = 0; j < count; j++){
                resultArray[index ++] = i;
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        System.out.println(JSONObject.toJSONString(new Solution1122_数组的相对排序().relativeSortArray(arr1,arr2)));
    }
}
