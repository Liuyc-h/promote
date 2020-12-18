package com.bj58.finance.platform.promote.algorithm.classification.枚举法;

import com.alibaba.fastjson.JSONObject;

/**
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution283 {

    /**
     * 这个我觉得也可以归为枚举法
     *
     * 枚举所有出现的情况
     *
     * 先定义一个0开始的地方startZero = - 1
     *   startZero < 0 并且nums[i] = 0,对startZero赋值
     *   startZero < 0 并且nums[i] ！= 0, 跳过，不需要变换
     *   startZero >= 0 并且nums[i] = 0, 跳过，不需要变换
     *   startZero >= 0 并且nums[i] != 0,进行交换
     *     交换后需要变更0开始地方的索引
     *      nums[startZero + 1] != 0则表明当前以后到i这个地方已经没0了,直接赋值为i
     *      否则，直接 加1即可
     *
     * **/
    public void moveZeroes(int[] nums) {
        //记录0开始的地方，
        int startZero = -1;
        for(int i =0; i< nums.length; i++){
            //startZero < 0 并且nums[i] = 0,对startZero赋值
            if(startZero < 0 && nums[i] == 0){
                startZero = i;
                continue;
            }
            //startZero < 0 并且nums[i] ！= 0, 跳过，不需要变换
            if(startZero < 0 && nums[i] != 0){
                continue;
            }
            // startZero >= 0 并且nums[i] = 0, 跳过，不需要变换
            if(startZero >= 0 && nums[i] == 0){
                continue;
            }
            //startZero >= 0 并且nums[i] != 0,进行交换
            swap(nums,startZero,i);
            //重置startZero开始的地方
            //如果nums[startZero + 1] != 0,直接赋值为i
            if(startZero < (nums.length -1) && nums[startZero + 1] != 0){
                startZero = i;
            }else{//加一即可
                startZero = startZero + 1;
            }
        }
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,3,12};

        new Solution283().moveZeroes(array);

        System.out.println(JSONObject.toJSONString(array));
    }
}
