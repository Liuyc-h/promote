package com.bj58.finance.platform.promote.algorithm.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *  字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
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
 * **/
public class Solution763 {

    public List<Integer> partitionLabels(String S) {
        //结果List
        List<Integer> resultList = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return resultList;
        }
        //字符串长度
        int length = S.length();
        if (length == 1) {
            resultList.add(1);
            return resultList;
        }
        //记录每一个字符得最大索引
        Map<Character,Integer> indexMap = new HashMap<>();
        for(int i = 0; i< S.length(); i++){
            indexMap.put(S.charAt(i),i);
        }
        //第一个字符串的最大索引位置
        int index = indexMap.get(S.charAt(0));
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < S.length(); i++){
            //比较最大索引
            index = Math.max(indexMap.get(S.charAt(i)),index);
            endIndex = i;
            if(i == index){
                resultList.add(endIndex - startIndex + 1);
                startIndex = i + 1;
                endIndex = i+ 1;
            }
        }
        return resultList;



    }

    public List<Integer> partitionLabels1(String S) {
        //结果List
        List<Integer> resultList = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return resultList;
        }
        //字符串长度
        int length = S.length();
        if (length == 1) {
            resultList.add(1);
            return resultList;
        }
        //记录每一个字符得最大索引
        int[] indexArray = new int[26];
        for(int i = 0; i< S.length(); i++){
            indexArray[S.charAt(i) - 'a'] = i;
        }
        //第一个字符串的最大索引位置
        int index = indexArray[S.charAt(0) -'a'];
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < S.length(); i++){
            //比较最大索引
            index = Math.max(indexArray[S.charAt(i) -'a'],index);
            endIndex = i;
            if(i == index){
                resultList.add(endIndex - startIndex + 1);
                startIndex = i + 1;
                endIndex = i+ 1;
            }
        }
        return resultList;
    }
}
