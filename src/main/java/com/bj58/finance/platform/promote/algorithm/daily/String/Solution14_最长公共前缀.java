package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution14_最长公共前缀 {
    //分治法
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        //数组长度
        int length = strs.length;
        return commonPrefix(strs,0,length - 1);
    }
    //公共部分
    private String commonPrefix(String[] strs,int start,int end){
        if(start == end){
            return strs[start];
        }
        int middle = (start + end) / 2;

        String left = commonPrefix(strs, start, middle);
        String right = commonPrefix(strs, middle + 1, end);
        return getCommonPreFix(left,right);
    }
    //获取公共部分
    private String getCommonPreFix(String left,String right){
        if(left == null || right == null || left.length() == 0 || right.length() == 0){
            return "";
        }
        if(left.charAt(0) != right.charAt(0)){
            return "";
        }
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 1; i< Math.min(left.length(),right.length()); i++){
            if(left.charAt(i) != right.charAt(i)){
                break;
            }
            endIndex = i;
        }
        return left.substring(startIndex,endIndex + 1);
    }

}
