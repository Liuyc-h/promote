package com.bj58.finance.platform.promote.algorithm.daily.String;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution387 {

    public int firstUniqChar(String s) {

        if(s == null || s.length() == 0){
            return -1;
        }
        //一个二维数组记录，第一位记录出现次数，第二位记录出现的最大索引
        int[][] charArray = new int[26][2];
        for(int i = 0; i< s.length(); i++){
            int index = s.charAt(i) - 'a';
            charArray[index][0] ++;
            charArray[index][1] = Math.max(i,charArray[index][1]);
        }
        //未重复的索引
        int notRepeatFirstIndex = -1;
        for(int i =0; i < charArray.length; i++){
            if(charArray[i][0] != 1){
                continue;
            }
            if(notRepeatFirstIndex == -1){
                notRepeatFirstIndex = charArray[i][1];
            }
            notRepeatFirstIndex = Math.min(notRepeatFirstIndex,charArray[i][1]);
        }
        return notRepeatFirstIndex;
    }

//    //利用队列去做
//    public int firstUniqChar1(String s){
//
//    }

    public static void main(String[] args) {

    }
}
