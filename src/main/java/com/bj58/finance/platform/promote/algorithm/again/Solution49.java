package com.bj58.finance.platform.promote.algorithm.again;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs){

        Map<String,List<String>> resultMap = new HashMap<>();

        for(int i = 0; i< strs.length; i++){

            if(strs[i] == null ){
                continue;
            }
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);

            String newStr = new String(array);
            if(resultMap.containsKey(newStr)){
                List<String> result = resultMap.get(newStr);
                result.add(strs[i]);
            }else{
                List<String> result = new ArrayList<>();
                result.add(strs[i]);
                resultMap.put(newStr,result);
            }
        }
        return new ArrayList<>(resultMap.values());
    }
}
