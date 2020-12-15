package com.bj58.finance.platform.promote.algorithm.daily.String;

/***
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution738 {

    public int monotoneIncreasingDigits(int N) {
        //小于等于10的话特殊处理
        if (N <= 10) {
            return N - 1 < 0 ? 0 : N - 1;
        }
        //转换为字符串来进行操作
        String str = "" + N;
        //转换为字符数据
        char[] array = str.toCharArray();
        //找出重复开始的点
        int repeatIndex = 0;
        //裂开的点
        int crackIndex = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                crackIndex = i + 1;
                break;
            }
            if (array[i] < array[i + 1]) {
                repeatIndex = i + 1;
                continue;
            }
        }
        if (crackIndex == -1) {
            return N;
        }
        StringBuilder builder = new StringBuilder();
        if(repeatIndex == 0){
            if(array[0] != '1'){
                builder.append((char)(array[0] - 1));
            }
            for(int i =1; i< array.length;i++){
                builder.append('9');
            }
        }else{
            for(int i = 0;i < repeatIndex; i++){
                builder.append(array[i]);
            }
            builder.append((char)(array[repeatIndex] - 1));
            for(int i = repeatIndex + 1; i< array.length; i++){
                builder.append('9');
            }
        }
        return Integer.parseInt(builder.toString());
    }

    public int monotoneIncreasingDigits1(int N) {
        int ones = 111111111;
        int res = 0;
        for(int i=0;i<9;i++){
            while(res+ones>N){
                ones/=10;
            }
            res += ones;
            if(ones==0)
                break;
        }
        return res;
    }

}
