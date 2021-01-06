package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *   给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution771_宝石和石头 {

    public int numJewelsInStones(String jewels, String stones) {

        if(jewels == null || stones == null || jewels.length() == 0 || stones.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for(int i =0; i < jewels.length(); i++){
            set.add(jewels.charAt(i));
        }
        int result = 0;
        for(int i = 0; i< stones.length(); i++){
            if(set.contains(stones.charAt(i))){
                result ++;
            }
        }
        return result;
    }
}
