package com.bj58.finance.platform.promote.algorithm.daily.String;

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
public class Solution14_最长公共前缀 {
    /***
     *  分治法
     * **/
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        //数组的长度
        int length = strs.length;
        return commonPrefix(strs,0,length - 1);
    }
    //分治法去找公共长度
    private String commonPrefix(String[] strs,int start,int end){
        if(start == end){
            return strs[start];
        }
        int middle = (start + end) / 2;
        String leftStr = commonPrefix(strs, start, middle);
        String rightStr = commonPrefix(strs, middle + 1, end);
        return getCommonPrefix(leftStr,rightStr);
    }
    //获取公共部分
    private String getCommonPrefix(String left,String right){

        if(left == null || right == null || left.length() == 0 || right.length() == 0){
            return "";
        }
        int length = Math.min(left.length(),right.length());
        int startIndex = -1;
        int endIndex = -1;
        for(int i= 0;i < length; i++){
            if(left.charAt(i) != right.charAt(i)){
                break;
            }
            if(startIndex == -1){
                startIndex = i;
                endIndex = i;
            }else{
                endIndex = i;
            }
        }
        return startIndex == -1 ? "" : left.substring(startIndex,endIndex + 1);
    }

    /***
     *  寻常的遍历
     * **/
    public String longestCommonPrefix1(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        //先获取一个元素
        String common = strs[0];
        for(int i = 1; i< strs.length; i++){
            if(common == null || strs[i] == null || common.length() == 0 || strs[i].length() == 0){
                return "";
            }
            int length = Math.min(strs[i].length(),common.length());
            int startIndex = -1;
            int endIndex = -1;
            for(int j= 0;j < length; j++){
                if(common.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                if(startIndex == -1){
                    startIndex = j;
                    endIndex = j;
                }else{
                    endIndex = j;
                }
            }
            common = startIndex == -1 ? "" : common.substring(startIndex,endIndex + 1);
        }
        return common;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new Solution14_最长公共前缀().longestCommonPrefix1(strs));

    }
}
