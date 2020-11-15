package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.Deque;
import java.util.LinkedList;

/**
 *给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution402 {

    /**
     *  还不是连续的几个，有点蛋疼啊
     * */
    public String removeKdigits(String num, int k) {

        if(num.length() == k){
            return "0";
        }

        int length = num.length();
        //定义一个双端队列
        Deque<Character> deque = new LinkedList<>();
        for(int i =0; i< length; i++ ){

            char digit = num.charAt(i);
            //因为既要维护顺序，又要取到最小值，以k为限制，如果遇到比之前的小的值，需要last出队列，进行替换
            while(!deque.isEmpty() && k > 0 && deque.peekLast() > digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        //如果大于length - k，证明都是升序了，去掉最后 length - k - deque.size
        for(int i = 0; i < k; i++){
            deque.pollLast();
        }
        StringBuilder builder = new StringBuilder();
        Boolean preZeroFlag = true;

        while(!deque.isEmpty()){
            if(preZeroFlag && deque.peekFirst() == '0'){
                deque.pollFirst();
                continue;
            }
            preZeroFlag = false;
            builder.append(deque.pollFirst());
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }


    public static void main(String[] args) {
        String num = "10";

        System.out.println(new Solution402().removeKdigits(num,1));
    }

//    public String removeKdigits(String num, int k) {
//
//        if(num.length() == k){
//            return "0";
//        }
//        int length = num.length();
//        //定义一个字串
//        char[] subNum = new char[num.length() - k];
//        for(int i = k; i < length; i++){
//            subNum[i - k] = num.charAt(i);
//        }
//        int result =new Integer(new String(subNum));
//        int index = 0;
//        for(int i = 0; i< length -k; i++){
//            subNum[index ++] = num.charAt(i);
//            int data = new Integer(new String(subNum));
//            result = Math.min(result,data);
//        }
//        return new Integer(result).toString();
//    }
}
