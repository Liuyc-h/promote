package com.bj58.finance.platform.promote.algorithm.daily.String;


import java.util.ArrayList;
import java.util.List;

/***
 *字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution763 {

    public List<Integer> partitionLabels(String S) {
        if(S == null){
            return new ArrayList<>();
        }
        int length = S.length();
        //定义一个数组，记录字符出现的最大下标
        //S.charAt[i] - a 就是indexArray的索引
        int[] indexArray = new int[26];
        for(int i = 0; i < length; i++ ){
            int index = Math.max(indexArray[S.charAt(i) - 'a'],i);
            indexArray[S.charAt(i) - 'a'] = index;
        }
        List<Integer> lengthList = new ArrayList<>();
        //开始和结束指针
        int start = 0;
        int end = 0;
        for(int i = 0; i < length; i++){
            //比较end的最大值
            end = Math.max(end,indexArray[S.charAt(i) - 'a']);
            //如果i = end，表明后面的字符中没有 strat ->end 中的字符了，此时这次已经可以结束了
            if(i == end){
                int sonLength = end - start + 1;
                lengthList.add(sonLength);
                start = end + 1;
                end = end + 1;
            }
        }
        return lengthList;

    }


}
