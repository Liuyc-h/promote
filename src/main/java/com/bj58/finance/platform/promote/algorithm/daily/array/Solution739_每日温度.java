package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.Deque;
import java.util.LinkedList;

/***
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution739_每日温度 {

    public int[] dailyTemperatures(int[] T) {
        //特殊处理
        if(T == null || T.length == 0){
            return new int[]{};
        }
        //T的长度
        int length = T.length;
        //结果
        int[] resultArray = new int[length];
        //定义一个队列
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < length; i++){
            //当前的值
            int curr = T[i];
            while(!deque.isEmpty() && curr > T[deque.peek()]){
                int index = deque.pop();
                resultArray[index] = i - index;
            }
            deque.push(i);
        }
        return resultArray;
    }
}
