package com.bj58.finance.platform.promote.algorithm.daily.String;

/***
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution859_亲密字符串 {

    public boolean buddyStrings(String A, String B) {

        if(A == null || B == null || A.length() == 0 || A.length() != B.length()){
            return false;
        }
        //只能交换两个
        if(A.equals(B)){
            int[] Achar = new int[26];
            for(int i = 0; i< A.length(); i++){
                int index = A.charAt(i) - 'a';
                Achar[index] ++;
                if(Achar[index] > 1){
                    return true;
                }
            }
            return false;
        }
        //不一样得数
        int diffCount = 0;
        int firstIndex = -1;
        int secondIndex = -1;
        for(int i = 0; i <A.length(); i++){
            if(A.charAt(i) == B.charAt(i)){
                continue;
            }
            diffCount ++;
            if(firstIndex == -1){
                firstIndex = i;
                continue;
            }
            if(secondIndex == -1){
                secondIndex = i;
            }
        }

        return diffCount != 2 ? false :
                (A.charAt(firstIndex) == B.charAt(secondIndex) && A.charAt(secondIndex) == B.charAt(firstIndex));
    }


    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "badc";

        System.out.println(new Solution859_亲密字符串().buddyStrings(s1,s2));
    }
}
