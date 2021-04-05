package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 *
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution781_森林中得兔子 {

    public int numRabbits(int[] answers) {
        //
        if(answers == null || answers.length == 0){
            return 0;
        }
        //每个数出现得频率
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< answers.length; i++){
            int count = map.getOrDefault(answers[i],0) + 1;
            map.put(answers[i],count);
        }
        int result = 0;
        for(int key : map.keySet()){
            int value = map.get(key);
            if(key == 0){
                result = result + value;
            }else {
                int k = value / (key + 1);
                k = value % (key + 1) == 0 ? k : k + 1;
                result = result + (key + 1) * k;
            }

        }
        return result;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1,0,1,0,0};
        System.out.println(new Solution781_森林中得兔子().numRabbits(array));

    }
}
