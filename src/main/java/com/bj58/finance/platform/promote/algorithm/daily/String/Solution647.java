package com.bj58.finance.platform.promote.algorithm.daily.String;

public class Solution647 {
    /**
     *  先找出中心点，然后向两边扩展，中心点为 单个字符和2个字符的
     *
     *
     * */
    public int countSubStrings1(String s){
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    public int countSubstrings(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }
        //字符串长度
        int length = s.length();
        //结果长度
        int resultCount = s.length();
        if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return resultCount + 1;
        }
        for(int i = 1; i < length - 1; i++){
            //不存在回文子串的集合
            if(s.charAt(i) != s.charAt(i - 1) && s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i + 1) != s.charAt(i - 1)){
                continue;
            }
            if(s.charAt(i) == s.charAt(i - 1)){
                int left = i - 1;
                int right = i;
                resultCount = resultCount + getResultCount(s,left,right);
            }
            if(s.charAt(i) == s.charAt(i + 1)){
                int left = i;
                int right = i + 1;
                resultCount = resultCount + getResultCount(s,left,right);
            }
            if(s.charAt(i - 1) == s.charAt(i + 1)){
                int left = i - 1;
                int right = i + 1;
                resultCount = resultCount + getResultCount(s,left,right);
            }
        }
        return resultCount;
    }

    private int getResultCount(String s,int left,int right){

        int length = s.length();
        int resultCount = 0;

        while(left >= 0 && right < length){
            if(s.charAt(left) == s.charAt(right)){
                resultCount ++;
                left --;
                right ++;
                continue;
            }
            return resultCount;
        }
        return resultCount;
    }


    public static void main(String[] args) {
        String s = "aaaaa";

        System.out.println(new Solution647().countSubStrings1(s));
    }
}
