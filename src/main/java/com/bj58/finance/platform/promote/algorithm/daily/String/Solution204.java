package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ***/
public class Solution204 {
    public int countPrimes(int n) {
        int count = 0;
        for(int i =0; i < n; i++){
            if(isPrime(i)){
                count ++;
            }
        }
        return count;
    }
    /***
     *  判断是否是质数
     * */
    private Boolean isPrime(int value){

        if(value <= 3){
            return value > 1;
        }
        if(value % 6 != 1 && value % 6 != 5){
            return false;
        }
        for(int i = 2; i * i <= value; i++){
            if(value % i == 0 ){
                return false;
            }
        }
        return true;
    }
}
