package com.bj58.finance.platform.promote.algorithm.daily.array;
/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution845 {

    public int longestMountain(int[] A){
        int length = A.length;

        int mountainSize = 0;

        for(int i =0; i < length - 1;i++){

            if(i > 0 && A[i] > A[i-1] && A[i] > A[i + 1]){
                //往左遍历的开始点
                int left = i - 1;
                //往右遍历的开始点
                int right = i + 1;
                //往左遍历
                while(left > 0 && A[left] > A[left - 1]){
                    left --;
                }
                //往右遍历
                while(right < length - 1 && A[right] > A[right + 1]){
                    right ++;
                }
                mountainSize = Math.max(mountainSize,right - left + 1);
            }
        }
        return mountainSize;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,1,4,7,3,2,5};

        System.out.println(new Solution845().longestMountain(array));
    }
}
