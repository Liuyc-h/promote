package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.Arrays;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 ***/
public class Solution17_10_主要元素 {

    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);

        //该元素得起始和结束索引
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[startIndex]) {
                endIndex = i;
                continue;
            }

            int length = endIndex - startIndex + 1;
            if (length > nums.length / 2) {
                return nums[startIndex];
            }
            startIndex = i;
            endIndex = i;
        }
        int length = endIndex - startIndex + 1;
        if (length > nums.length / 2) {
            return nums[startIndex];
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1,2,5,9,5,9,5,5,5};
        System.out.println(new Solution17_10_主要元素().majorityElement1(array));
    }


    public int majorityElement1(int[] nums) {
        // 摩尔投票算法
        int major = 0, cnt = 0;
        for (int x : nums) {
            if (cnt == 0) {
                major = x;
                cnt++;
            } else {
                if (major == x)
                    cnt++;
                else
                    cnt--;
            }
        }

        if (cnt > 0) {
            int t = 0;
            for (int x : nums)
                if (x == major)
                    t++;
            if (t > nums.length / 2) return major;
        }

        return -1;

    }
}
