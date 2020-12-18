package com.bj58.finance.platform.promote.algorithm.classification.枚举法;

import com.alibaba.fastjson.JSONObject;

/**
 *  给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution338 {

    /**
     *  我觉得可以归为枚举，枚举所有的情况，找出规律，就可以了
     *  如果i & (i - 1) = 0，则证明i是在2的幂次方上面，2的幂次方上面的位数都为1个
     *  接下来的如果是偶数的话，某个数 * 2得来，即某个数左移一位，低位补0，1的个数是一样的
     *  如果为奇数的话，证明是上一个偶数加1所得，所以比特位为1 的加一
     * **/
    public int[] countBits(int num) {
        //定义返回结果数组
        int[] resultArray = new int[num + 1];
        //先赋值0
        resultArray[0] = 0;
        //循环取数
        for (int i = 1; i <= num; i++) {
            //如果i & (i - 1) = 0，则证明i是在2的幂次方上面，2的幂次方上面的位数都为1个
            if ((i & (i - 1)) == 0) {
                resultArray[i] = 1;
            } else if (i % 2 == 0) {//接下来的如果是偶数的话，某个数 * 2得来，即某个数左移一位，低位补0
                resultArray[i] = resultArray[i / 2];
            } else {//如果为奇数的话，证明是上一个偶数加1所得，所以比特位为1 的加一
                resultArray[i] = resultArray[i - 1] + 1;
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {

        int num = 2;

        System.out.println(JSONObject.toJSONString(new Solution338().countBits(num)));


    }
}
