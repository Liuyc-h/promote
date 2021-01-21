package com.bj58.finance.platform.promote.algorithm.daily.array;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution628_三个数得最大乘积 {
    /**
     *
     **/
    public int maximumProduct(int[] nums) {
        //找出三个最大得和两个最小的
        int firstMax = nums[0];
        int secondMax = nums[1];
        int thirdMax = nums[2];

        int firstMin = nums[0];
        int secondMin = nums[1];

        for (int i = 2; i < nums.length; i++) {

            if (i > 2) {
                //求四个数中的前三个大值
                int temp1 = Math.min(firstMax, nums[i]);
                firstMax = Math.max(firstMax, nums[i]);

                int temp2 = Math.min(secondMax, temp1);
                secondMax = Math.max(temp1, secondMax);

                thirdMax = Math.max(temp2, thirdMax);
            }
            //寻找三个数中的最小两个值
            int temp3 = Math.max(firstMin, nums[i]);
            firstMin = Math.min(firstMin, nums[i]);
            secondMin = Math.min(temp3, secondMin);
        }
        //找出三个中最大的
        int tempMax = Math.max(firstMax, secondMax);
        tempMax = Math.max(tempMax, thirdMax);

        return (tempMax * firstMin * secondMin > firstMax * secondMax * thirdMax) ?
                tempMax * firstMin * secondMin : firstMax * secondMax * thirdMax;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-100, -98, -1, 2, 3, 4};

        System.out.println(new Solution628_三个数得最大乘积().maximumProduct(array));
    }
}
