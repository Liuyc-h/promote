package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *  给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
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
 * **/
public class Solution767 {

    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;//前为偶数，后为奇数
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }


    public String reorganizeString1(String S){
        //把字符串S转化为字符数组
        char[] alphabetArr = S.toCharArray();
        //记录每个字符出现的次数
        int[] charCount = new int[26];
        //字符串的长度
        int length = S.length();
        //字符出现最多的所在的索引
        int maxCountIndex = 0;
        //统计每个字符出现的次数,并找出字符出现的最大的数据量所在索引
        for (int i = 0; i < length; i++) {
            int index = S.charAt(i) - 'a';
            charCount[index] ++;
            if(charCount[maxCountIndex] < charCount[index]){
                maxCountIndex = index;
            }
        }
        //如果一个字符大于  长度 + 1 的一半，证明肯定会有相邻的相同字母，直接返回空字符串
        if(charCount[maxCountIndex] > (S.length() + 1) / 2){
            return "";
        }
        //结果的数组形式，最后会再转化为字符串的
        char[] result = new char[length];
        int index = 0;
        //先把出现次数最多的字符存储在数组下标为偶数的位置上
        while (charCount[maxCountIndex]-- > 0) {
            result[index] = (char) (maxCountIndex + 'a');
            index += 2;
        }
        //然后再把剩下的字符存储在其他位置上
        for (int i = 0; i < charCount.length; i++) {
            while (charCount[i]-- > 0) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(result);
    }


    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution767().reorganizeString(s));
    }

}
