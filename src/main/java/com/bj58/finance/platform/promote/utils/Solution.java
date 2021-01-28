package com.bj58.finance.platform.promote.utils;

import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Deque<Character> deque = new LinkedList<>();
        int length = s.length();
        for(int i = 0; i< length; i++){
            if(deque.isEmpty()){
               deque.push(s.charAt(i));
               continue;
            }
            if(isValue(deque,s.charAt(i))){
                deque.pop();
            }else{
                deque.push(s.charAt(i));
            }
        }
        return deque.isEmpty() ? true : false;
    }
    //
    private Boolean isValue(Deque<Character> deque,char curr){
        //()[]{}
        if(curr == ')' && deque.peek() == '('){
            return true;
        }
        if(curr == ']' && deque.peek() == '['){
            return true;
        }
        if(curr == '}' && deque.peek() == '{'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "([)]";

        System.out.println(new Solution().isValid(s));
    }
}
