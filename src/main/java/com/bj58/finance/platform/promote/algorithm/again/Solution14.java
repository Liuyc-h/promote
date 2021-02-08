package com.bj58.finance.platform.promote.algorithm.again;

/**
 *  编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * **/
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        //起始结束位置
        int start = 0;
        int end = strs.length - 1;
        return commonPart(strs,start,end);
    }

    private String commonPart(String[] strs ,int start,int end){
        if(start == end){
            return strs[start] == null ? "" : strs[start];
        }

        int middle = (start + end) / 2;
        String left = commonPart(strs, start, middle);
        String right = commonPart(strs,middle + 1,end);
        return getCommonPart(left,right);
    }
    private String getCommonPart(String left,String right){
        if(left == null || right == null || left.length() == 0 || right.length() == 0){
            return "";
        }
        int endIndex = -1;
        for(int i = 0; i< Math.min(left.length(),right.length()); i++){
            if(left.charAt(i) != right.charAt(i)){
                break;
            }
            endIndex = i;
        }
        return endIndex == -1 ? "" : left.substring(0,endIndex + 1);
    }
}
