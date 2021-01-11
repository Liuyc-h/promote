package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

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
public class Solution49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        //结果map
        Map<String,List<String>> resultMap = new HashMap<>();
        for(int i =0; i < strs.length; i++){

            String str = strs[i];
            char[] strArary = str.toCharArray();
            Arrays.sort(strArary);
            List<String> result = resultMap.getOrDefault(new String(strArary),new ArrayList<>());
            result.add(str);
            resultMap.put(new String(strArary),result);
        }
        return new ArrayList<>(resultMap.values());
    }

    public static void main(String[] args) {

        String[] strs =new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(JSONObject.toJSONString(new Solution49_字母异位词分组().groupAnagrams(strs)));

    }
}
