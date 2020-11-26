package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *  给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution1370 {

    public String sortString(String s){

        if(s == null || s.length() <= 1){
            return s;
        }
        //字符长度
        int length = s.length();
        //定义一个数组，只有小写字符串
        int[] array = new int[26];
        for(int i =0; i < length; i ++){
            int index = s.charAt(i) - 'a';
            array[index] ++;
        }
        //结果字符串
        StringBuilder resultBuilder = new StringBuilder();
        //使用过的个数
        int usedCount = 0;
        //从大到小还是从小到大的标志,先从小到大
        Boolean flag = true;
        while(usedCount < length ){
            //从小到大
            if(flag){
                for(int i =0 ; i < 26; i++){
                    if(array[i] == 0){
                        continue;
                    }
                    int value = 'a' + i;
                    resultBuilder.append((char) value);
                    array[i] --;
                    usedCount ++;
                }
                flag = false;
            }else{
                for(int i = 25; i>=0; i--){
                    if(array[i] == 0){
                        continue;
                    }
                    int value = 'a' + i;
                    resultBuilder.append((char) value);
                    array[i] --;
                    usedCount ++;
                }
                flag = true;
            }
        }
        return resultBuilder.toString();
    }





    public static void main(String[] args) {

        String s = "gggggggg";

        System.out.println(new Solution1370().sortString(s));

    }
}
