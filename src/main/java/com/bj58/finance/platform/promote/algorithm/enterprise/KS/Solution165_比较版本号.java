package com.bj58.finance.platform.promote.algorithm.enterprise.KS;

import javafx.util.Pair;

/***
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 *
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 *
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 *
 * 返回规则如下：
 *
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution165_比较版本号 {

    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null){
            return 0;
        }
        //version1的值
        int ver1Length = version1.length();
        //version2的值
        int ver2Length = version2.length();
        //ver1的滑动索引
        int slide1Index = 0;
        //ver2的滑动索引
        int slide2Index = 0;
        //第一个数据的值
        int num1 = 0;
        //第二个数据的值
        int num2 = 0;
        //
        while(slide1Index < ver1Length || slide2Index < ver2Length){
            if(slide1Index < ver1Length && version1.charAt(slide1Index) != '.' ){
                num1 = num1 * 10 + Integer.valueOf(version1.charAt(slide1Index) + "");
                slide1Index ++;
            }
            if(slide2Index < ver2Length && version2.charAt(slide2Index) != '.' ){
                num2 = num2 * 10 + Integer.valueOf(version2.charAt(slide2Index) + "");
                slide2Index ++;
            }

            if(slide2Index < ver2Length && slide1Index < ver1Length
                    && version1.charAt(slide1Index) == '.' && version2.charAt(slide2Index) == '.'){
                if(num1 > num2 ){
                    return 1;
                }else if(num2 > num1){
                    return -1;
                }
                num1 = 0;
                num2 = 0;
                slide1Index ++;
                slide2Index ++;
            }else if(slide1Index >= ver1Length && slide2Index < ver2Length && version2.charAt(slide2Index) == '.'){
                if(num1 > num2 ){
                    return 1;
                }else if(num2 > num1){
                    return -1;
                }
                num1 = 0;
                num2 = 0;
                slide2Index ++;
            }else if(slide2Index >= ver2Length && slide1Index < ver1Length && version1.charAt(slide1Index) == '.'){
                if(num1 > num2 ){
                    return 1;
                }else if(num2 > num1){
                    return -1;
                }
                num1 = 0;
                num2 = 0;
                slide1Index ++;
            }else if(slide1Index >= ver1Length && slide2Index >= ver2Length){
                if(num1 > num2 ){
                    return 1;
                }else if(num2 > num1){
                    return -1;
                }
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        String s1 = "1.00.1";
        String s2 = "1.0.2";

        System.out.println(new Solution165_比较版本号().compareVersion1(s1,s2));
    }

    public int compareVersion1(String version1, String version2){
        if(version1 == null || version2 == null){
            return 0;
        }
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }


    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        // if pointer is set to the end of string
        // return 0
        if (p > n - 1) {
            return new Pair(0, p);
        }
        // find the end of chunk
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }
        // retrieve the chunk
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        } else {
            i = Integer.parseInt(version.substring(p, n));
        }
        // find the beginning of next chunk
        p = pEnd + 1;

        return new Pair(i, p);
    }

    public int compareVersion2(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();

        // compare versions
        int i1, i2;
        Pair<Integer, Integer> pair;
        while (p1 < n1 || p2 < n2) {
            pair = getNextChunk(version1, n1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }
}
