package com.bj58.finance.platform.promote.algorithm.again;


import java.util.HashMap;
import java.util.Map;

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

    public int firstUniqChar(String s){

        if(s == null || s.length() == 0){
            return -1;
        }
        //记录字符串的最大最小索引位置
        Map<Character,int[]> indexMap = new HashMap<>();
        //遍历
        for(int i = 0; i < s.length(); i++){

            if(indexMap.containsKey(s.charAt(i))){
                int[] indexArray = indexMap.get(s.charAt(i));
                indexArray[0] = Math.min(i,indexArray[0]);
                indexArray[1] = Math.max(i,indexArray[1]);
                indexMap.put(s.charAt(i),indexArray);
            }else{
                int[] indexArray = new int[]{i,i};
                indexMap.put(s.charAt(i),indexArray);
            }
        }
        //结果索引
        int resultIndex = -1;

        for(Character flow : indexMap.keySet()){
            int[] value = indexMap.get(flow);
            if(value[0] != value[1]){
                continue;
            }
            resultIndex = resultIndex == -1 ? value[0] : Math.min(resultIndex,value[0]);
        }
        return resultIndex;

    }
}
