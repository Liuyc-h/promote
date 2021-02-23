package com.bj58.finance.platform.promote.algorithm.again;

import com.alibaba.fastjson.JSONObject;

/***
 *  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution189 {

    public void rotate(int[] nums, int k) {
        //特殊情况处理
        if (nums == null || nums.length <= 1) {
            return;
        }
        //实际要旋转得步数
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    //翻转数组
    private void reverseArray(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        new Solution189().rotate1(array, 3);

        System.out.println(JSONObject.toJSONString(array));
    }

    public void rotate1(int[] nums, int k) {

        //特殊情况处理
        if (nums == null || nums.length <= 1) {
            return;
        }
        //实际要旋转得
        k = k % nums.length;
        //转换得次数，其实只需要一次引导，就能完成所有得交换，交换次数为数组得长度
        int count = 0;

        for(int i = 0; count < nums.length; i++){

            int curr = i;
            int data = nums[i];

            do{
                //下一个索引得位置
                int nextIndex = (curr + k) % (nums.length);
                //下一个索引得数据
                int nextTemp = nums[nextIndex];
                //设置数值
                nums[nextIndex] = data;
                //重置当前索引和当前交换得值
                curr = nextIndex;
                data = nextTemp;
                //count 加1
                count ++;
            }while(curr != i);
        }
    }
}
