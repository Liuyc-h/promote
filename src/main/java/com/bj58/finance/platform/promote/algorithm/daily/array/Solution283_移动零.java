package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
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
 *
 * **/
public class Solution283_移动零 {

    public void moveZeroes(int[] nums) {
        //特殊处理
        if(nums == null || nums.length == 0){
            return;
        }
        //开始索引
        int startZeroIndex = -1;
        for(int i = 0; i < nums.length; i++){
            //索引为0，且startZeroIndex = -1，设置参数
            if(nums[i] == 0 && startZeroIndex == -1){
                startZeroIndex = i;
                continue;
            }
            //此时再有0的直接跳过即可
            if(nums[i] == 0 || startZeroIndex == -1){
                continue;
            }
            nums[startZeroIndex] = nums[i];
            nums[i] = 0;
            if( nums[startZeroIndex + 1] == 0){
                startZeroIndex ++;
            }else{
                startZeroIndex = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,3,12};

        new Solution283_移动零().moveZeroes(array);

        System.out.println(JSONObject.toJSONString(array));
    }
}
