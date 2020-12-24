package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

/***
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution189 {



    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        new Solution189().rotate1(array,3);
        System.out.println(JSONObject.toJSONString(array));
    }
    /**
     *  通过观察环状数组的情况，只需要一个触发点，交换n次就能完成
     *
     * **/
    public void rotate(int[] nums, int k){

        if(nums == null || nums.length <= 1){
            return ;
        }
        //长度
        int length = nums.length;
        //实际交换的步数
        k = k % length;
        //如果连着环来看的话，最多交换length次就行了
        int count = 0;
        for(int start = 0; count < length; start ++){
            //当前的索引
            int curr = start;
            //当前的值
            int pre = nums[curr];
            do{
                //下一个落脚的索引位置
                int nextIndex = (curr + k) % length;
                //先把其中的值取出来缓存一下
                int temp = nums[nextIndex];
                //落脚点赋值
                nums[nextIndex] = pre;
                //下一个需要交换的值
                pre = temp;
                //当前索引位置
                curr = nextIndex;
                //交换次数加1
                count++;
            }while(start != curr);

        }
    }
    /***
     *通过翻转可以做到
     *  先把数组整体翻转一下，然后再翻转
     *    0，k- 1
     *    k- 1  -> length -1
     *    两个部分
     * */
    public void rotate1(int[] nums, int k){
        if(nums == null || nums.length <= 1 || k <= 0){
            return;
        }
        reverseArray(nums,0,nums.length - 1);
        reverseArray(nums,0,k % nums.length - 1);
        reverseArray(nums,k % nums.length,nums.length - 1);
    }
    /**
     *  翻转数组
     * **/
    private void reverseArray(int[] array,int start,int end){

        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start ++;
            end --;
        }
    }
}
