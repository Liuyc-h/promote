package com.bj58.finance.platform.promote.algorithm.daily.String;

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
public class Solution387_字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        Map<Character,int[]> sMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char flow = s.charAt(i);
            if(!sMap.containsKey(flow)){
                sMap.put(flow,new int[]{i,i});
            }else{
                int[] indexArray = sMap.get(flow);
                indexArray[1] = Math.max(indexArray[1],i);
            }
        }
        int minIndex = -1;
        for(char flow : sMap.keySet()){
            int[] index = sMap.get(flow);
            if(index[0] != index[1]){
                continue;
            }
            if(minIndex == -1){
                minIndex = index[0];
            }else{
                minIndex = Math.min(minIndex,index[0]);
            }
        }
        return minIndex;
    }
}
