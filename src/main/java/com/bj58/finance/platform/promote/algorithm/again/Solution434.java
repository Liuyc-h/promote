package com.bj58.finance.platform.promote.algorithm.again;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution434 {

    public int countSegments(String s) {

        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        //空格的索引
        int index = -1;
        for(int i = 0; i < s.length(); i++){

            if(index == -1 && s.charAt(i) == ' '){
                continue;
            }
            if(index == -1 && s.charAt(i) != ' '){
                result = result + 1;
                index = i;
                continue;
            }
            if(index != -1 && s.charAt(i) == ' '){
                index = -1;
                continue;
            }
        }
        return result;

    }
}
