package com.bj58.finance.platform.promote.algorithm.again;

/**
 *给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution767 {

    public String reorganizeString(String S){


        if(S == null || S.length() == 0){
            return S;
        }
        //字符串中字符出现得频率
        int[] charSize = new int[26];
        //字符出现得最高频率得下标
        int maxIndex = 0;
        for(int i =0; i < S.length(); i++){
            charSize[S.charAt(i) - 'a'] ++;
            if(charSize[S.charAt(i) - 'a'] > charSize[maxIndex]){
                maxIndex = S.charAt(i) - 'a';
            }
        }
        //如果大于一半，则不行了
        if(charSize[maxIndex] > (S.length() + 1) / 2){
            return "";
        }
        //结果字符串数组
        char[] result = new char[S.length()];
        int index  = 0;
        for(int i = 0; i < charSize[maxIndex]; i++){
            result[index] = (char) (maxIndex + 'a');
            index = index + 2;
        }
        charSize[maxIndex] = 0;
        for(int i = 0; i< 26; i++){

            for(int j = 0; j < charSize[i]; j++){
                if(index >= S.length()){
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index = index + 2;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "vvvlo";

        System.out.println(new Solution767().reorganizeString(s));
    }
}
