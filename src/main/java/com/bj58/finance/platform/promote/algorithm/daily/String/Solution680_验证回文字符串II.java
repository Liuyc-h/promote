package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 *给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution680_验证回文字符串II {

    public boolean validPalindrome(String s) {

        if(s == null){
            return false;
        }
        if(s.length() <= 1){
            return true;
        }
        int length = s.length();
        //左指针
        int left = 0;
        //右指针
        int right = length - 1;

        while(left <= right){
            //如果
            if(s.charAt(left) == s.charAt(right)){
                left ++;
                right --;
                continue;
            }
            //左边标志
            Boolean leftFlag = true;
            //右标志
            Boolean rightFlag = true;
            //先从左到右遍历
            for(int i = left + 1,j = right; i <= j; i++,j--){
                if(s.charAt(i) != s.charAt(j)){
                    leftFlag = false;
                    break;
                }
            }
            //先从右到左遍历
            for(int i = left ,j = right - 1; i <= j; i++,j--){
                if(s.charAt(i) != s.charAt(j)){
                    rightFlag = false;
                    break;
                }
            }
            return rightFlag || leftFlag;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

        System.out.println(new Solution680_验证回文字符串II().validPalindrome(s));
    }

    public boolean validPalindrome1(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;

    }
}
