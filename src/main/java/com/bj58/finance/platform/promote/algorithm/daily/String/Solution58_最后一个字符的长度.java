package com.bj58.finance.platform.promote.algorithm.daily.String;

import java.util.ArrayList;
import java.util.List;

/**
 *  58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * **/
public class Solution58_最后一个字符的长度 {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        List<String> resultList = new ArrayList<>();
        int startIndex = -1;
        int endIndex = -1;
        //
        for(int i =0; i< s.length(); i++){
            //为-1.并且还为空跳出
            if(startIndex == -1 && s.charAt(i) == ' '){
                continue;
            }
            //为-1，但是不为‘ ’，赋值
            if(startIndex == -1 && s.charAt(i) != ' '){
                startIndex = i;
                endIndex = i;
                continue;
            }
            //不为-1，但是charAt为‘ ’
            if(startIndex != -1 && s.charAt(i) == ' '){
                resultList.add(s.substring(startIndex,endIndex + 1));
                startIndex = -1;
                endIndex = -1;
                continue;
            }
            endIndex = i;
        }
        if(startIndex != -1){
            resultList.add(s.substring(startIndex,endIndex + 1));
        }

        return resultList.size() == 0 ? 0 : resultList.get(resultList.size() - 1).length();
    }


    public int lengthOfLastWord1(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int startIndex = -1;
        int endIndex = -1;
        for(int i = length -1;i>= 0; i--){
            //为-1.并且还为空跳出
            if(startIndex == -1 && s.charAt(i) == ' '){
                continue;
            }
            //为-1，但是不为‘ ’，赋值
            if(startIndex == -1 && s.charAt(i) != ' '){
                startIndex = i;
                endIndex = i;
                continue;
            }
            //不为-1，但是charAt为‘ ’
            if(startIndex != -1 && s.charAt(i) == ' '){
                break;
            }
            endIndex = i;
        }
        return startIndex == -1 ? 0 : (startIndex -endIndex + 1) ;
    }
}
