package com.bj58.finance.platform.promote.algorithm.classification.位运算;

/**
 *  给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution389 {

    /**
     *  统计法.这种只适合只含有固定字符集的情况，位运算和求和相减比较符合大众
     *  因为都是小写字母。所以只有26个
     *  定义两个26的数组，统计字符出现的频率
     *
     *  然后遍历两个数组，找出不一样的
     * **/
    public char findTheDifference(String s, String t) {
        if(s == null || s.length() == 0){
            return t.charAt(0);
        }

        int[] sArray = new int[26];

        int[] tArray = new int[26];

        int length = t.length();

        for(int i =0; i < length; i++){
            if(i != length - 1){
                int sIndex = s.charAt(i) - 'a';
                sArray[sIndex] ++;
            }
            int tIndex = t.charAt(i) - 'a';
            tArray[tIndex] ++;
        }
        for(int i =0; i< 26;i++){
            if(sArray[i] != tArray[i]){
                return (char) ('a'  + i);
            }
        }
        return ' ';
    }
    /**
     *  统计法
     *      因为都是小写字母。所以只有26个
     *      定义一个26的数组，统计字符出现的频率
     *
     *       然后遍历字符串的频率，不等于0的就是多余的字符
     * **/
    public char findTheDifference1(String s, String t) {
        if(s == null || s.length() == 0){
            return t.charAt(0);
        }

        int[] arary = new int[26];


        int length = t.length();

        for(int i =0; i < length; i++){
            if(i != length - 1){
                int sIndex = s.charAt(i) - 'a';
                arary[sIndex] ++;
            }
            int tIndex = t.charAt(i) - 'a';
            arary[tIndex] --;
        }
        for(int i =0; i< 26;i++){
            if(arary[i] > 0){
                return (char) ('a' + i);
            }
        }
        return ' ';
    }
    /**
     *  位运算
     *
     *  利用 0与某个数异或是自身，某个数和自身异或为0的方法来做
     * **/
    public char findTheDifference2(String s, String t) {
        if(s == null || s.length() == 0){
            return t.charAt(0);
        }

        int length = t.length();
        int res = 0;
        for(int i =0; i < length; i++){
            if(i != length - 1){
                res = res ^ s.charAt(i);
            }
            res = res ^ s.charAt(i);
        }
        return (char) res;
    }

    /**
     *  位运算
     *
     *  利用 0与某个数异或是自身，某个数和自身异或为0的方法来做
     * **/
    public char findTheDifference3(String s, String t) {
        if(s == null || s.length() == 0){
            return t.charAt(0);
        }

        int length = t.length();
        int resS = 0;
        int resT = 0;
        for(int i =0; i < length; i++){
            if(i != length - 1){
                resS = resS + s.charAt(i);
            }
            resT = resT + s.charAt(i);
        }
        return (char) (resT - resS);
    }


}
