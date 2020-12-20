package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.*;

/**
 *  给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 *
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 *
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 *
 * 输入："leetcode"
 * 输出："letcod"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution316 {


    public String removeDuplicateLetters(String s) {

        if(s == null || s.length() <= 0){
            return "";
        }
        //字符串长度
        int length = s.length();
        //记录字符在s中最后出现的索引
        int[] lastIndex = new int[26];
        for(int i =0; i< length; i++){
            int index = s.charAt(i) - 'a';
            lastIndex[index] = i;
        }
        //利用栈来操作字符
        Deque<Character> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[26];

        for(int i =0; i< length; i++){
            //如果当前遍历的字符已经在栈中出现，跳出
            if(visited[s.charAt(i) - 'a']){
                continue;
            }
            //栈中不为空，并且 栈顶元素大于当前元素，并且这个字符在以后还会出现，则删除栈顶元素
            //并把visited中字符的位置为false
            while(!deque.isEmpty() && deque.peekLast() > s.charAt(i)
                    && lastIndex[deque.peekLast() - 'a'] > i){
                Character top = deque.removeLast();
                visited[top - 'a'] = false;
            }
            deque.addLast(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
        }

        StringBuilder builder = new StringBuilder();

        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String str = "cdadabcc";

        System.out.println(new Solution316().removeDuplicateLetters(str));

    }
}
