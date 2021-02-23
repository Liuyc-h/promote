package com.bj58.finance.platform.promote.algorithm.again;

//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
// 👍 551 👎 0

public class Solution67 {

    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        reverse(aChar);
        reverse(bChar);
        int overFlow = 0;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < Math.max(aChar.length,bChar.length); i++){
            int aData = i >= aChar.length ? 0 : Integer.parseInt(aChar[i] + "");
            int bData = i >= bChar.length ? 0 : Integer.parseInt(bChar[i] + "");
            int currData = aData + bData + overFlow;

            overFlow = currData / 2;
            builder.append(currData % 2);
        }
        if(overFlow > 0){
            builder.append(overFlow);
        }
        char[] resultChar = builder.toString().toCharArray();
        reverse(resultChar);
        return new String(resultChar);
    }

    private void reverse(char[] array){

        int left = 0;
        int right = array.length - 1;
        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left ++;
            right --;
        }
    }


}
