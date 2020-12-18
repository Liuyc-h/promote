package com.bj58.finance.platform.promote.algorithm.classification.分治法;

/**
 *  编写一个函数来查找字符串数组中的最长公共前缀。
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
 * ***/
public class Solution14 {
    /**
     *  横向扫描
     * **/
    public String longestCommonPrefix(String[] strs) {
        //null或者长度为0，返回“”
        if(strs == null || strs.length == 0){
            return "";
        }
        //长度为1，返回本身
        if(strs.length == 1){
            return strs[0];
        }
        //取出第一个元素
        String resultStr =  strs[0];
        for(int i = 1; i < strs.length; i++){
            if(strs[i] == null || strs[i].length() == 0){
                return "";
            }
            int length = Math.min(resultStr.length(),strs[i].length());
            for(int j =0; j< length; j++ ){
                if(strs[i].charAt(j) != resultStr.charAt(j) ){
                    resultStr = resultStr.substring(0,j);
                    break;
                }else if( j == length - 1){
                    resultStr = resultStr.substring(0,length);
                }
            }
        }
        return resultStr;
    }

    public static void main(String[] args) {

//        String[] strs = new String[]{"flower","flow","flight"};

        String[] strs = new String[]{"ab","a"};
        System.out.println(new Solution14().longestCommonPrefix(strs));
    }

    /**
     *  分治算法，递归
     * **/
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

}
