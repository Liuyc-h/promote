package com.bj58.finance.platform.promote.algorithm.daily.array;

/***
 *给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
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
 *
 * */
public class Solution338_比特位计数 {
    /**
     *
     *
     * **/
    public int[] countBits(int num) {

        int[] resultArray = new int[num + 1];
        //第一个可以直接赋为0
        resultArray[0] = 0;
        for(int i =1; i<= num; i++ ){
            //对于能被2整除的数，相当于 i/ 2 左移一位，所以i/2 和i所占的比特位1的个数是一样的
            if(i % 2 == 0){
                resultArray[i] = resultArray[ i / 2];
            }else if( i % 2 != 0){//对于奇数的数据，一定是前一位 + 1得来，前一位一定是偶数，偶数 + 1相当于比特位多了一位1
                resultArray[i] = resultArray[i - 1] + 1;
            }
        }
        return resultArray;
    }
}
