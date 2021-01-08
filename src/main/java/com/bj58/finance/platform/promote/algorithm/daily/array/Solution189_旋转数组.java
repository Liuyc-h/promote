package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

/**
 * /***
 *  * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *  *
 *  * 示例 1:
 *  *
 *  * 输入: [1,2,3,4,5,6,7] 和 k = 3
 *  * 输出: [5,6,7,1,2,3,4]
 *  * 解释:
 *  * 向右旋转 1 步: [7,1,2,3,4,5,6]
 *  * 向右旋转 2 步: [6,7,1,2,3,4,5]
 *  * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *  * 示例 2:
 *  *
 *  * 输入: [-1,-100,3,99] 和 k = 2
 *  * 输出: [3,99,-1,-100]
 *  * 解释:
 *  * 向右旋转 1 步: [99,-1,-100,3]
 *  * 向右旋转 2 步: [3,99,-1,-100]
 *  * 说明:
 *  *
 *  * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *  * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/rotate-array
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  *
 *
  **/
public class Solution189_旋转数组 {

    public void rotate(int[] nums, int k){

        if(nums == null || nums.length == 0){
            return;
        }
        //数组长度
        int length = nums.length;
        //实际要移动的位数
        k = k % length;
        //交换的次数，找到一个启动点，然后如同抢座位一样，
        // 经历一次循环，也就是length次交换就会完成了
        int count = 0;
        for(int i =0; count < length; i++ ){
            //当前替换的索引
            int currIndex = i;
            //当前替换的值
            int preData = nums[i];
            do{
                //找出当前索引需要移动的位置
                int next = (currIndex + k) % length;
                //覆盖位置的值先缓存起来
                int temp = nums[next];
                //移动的新位置进行赋值
                nums[next] = preData;
                //重置需要移动的索引位置
                currIndex = next;
                //重置需要移动的索引你位置的值
                preData = temp;
                //交换次数加1
                count ++;
            }while(currIndex != i);
        }
    }


    public void rotate1(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return;
        }
        reverseArray(nums,0,nums.length- 1);
        reverseArray(nums,0,k % nums.length - 1);
        reverseArray(nums,k % nums.length ,nums.length - 1);
    }
    /**
     * 翻转数组
     * **/
    private void reverseArray(int[] array,int start,int end){
         //左节点
        int left = start;
        //右节点
        int right = end;
        while(left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        new Solution189_旋转数组().rotate(array,3);
        System.out.println(JSONObject.toJSONString(array));
    }
}
