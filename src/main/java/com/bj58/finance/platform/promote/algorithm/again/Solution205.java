package com.bj58.finance.platform.promote.algorithm.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 可以假设 s 和 t 长度相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ***/
public class Solution205 {

    public boolean isIsomorphic(String s, String t){
        if(s == null || t == null ||  s.length() != t.length()){
            return false;
        }
        //建立字符映射
        Map<Character,Character> mapping = new HashMap<>();
        //将value值放入集合
        Set<Character> valueSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++){

            if(!mapping.containsKey(s.charAt(i))){
                // a -> c ,b -> c的这种情况出现
                if(valueSet.contains(t.charAt(i))){
                    return false;
                }
                mapping.put(s.charAt(i),t.charAt(i));
                valueSet.add(t.charAt(i));
            }else{
                Character sChar = mapping.get(s.charAt(i));
                if(sChar != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
