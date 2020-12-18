package com.bj58.finance.platform.promote.algorithm.classification.单调栈;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 *请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution739 {

    /**
     *  单调栈
     *  利用栈先进后出的特性
     *
     *  先将元素索引下标压入栈中，
     *  每压入一个元素之前都要与栈中的元素进行比较，如果T[stack.peek()] <T[i]，则之前的元素出栈，记录差值
     *   其他不做处理
     *
     * **/
    public int[] dailyTemperatures(int[] T) {
        //为空或者长度为0
        if(T == null || T.length <= 0){
            return new int[]{};
        }

        int[] resultArray = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< T.length; i++){

            while(!stack.isEmpty() && T[stack.peek()] <T[i]){
                int index = stack.pop();
                resultArray[index] = i - index;
            }
            stack.push(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {

        int[] array = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        int[] resultArray = new Solution739().dailyTemperatures(array);

        System.out.println(JSONObject.toJSONString(resultArray));


    }
}
