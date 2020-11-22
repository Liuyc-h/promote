package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 *
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 *
 * 输出: -1
 *
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution134 {

    //类似于暴力解法
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int length = gas.length;
        //先找出来能启动得
        List<Integer> list = new ArrayList<>();
        for(int i =0; i< length; i++){
            if(gas[i] >= cost[i]){
                list.add(i);
            }
        }
        if(list.size() == 0){
            return -1;
        }
        for(int index : list){

            int sum = 0;
            for(int i = index; i< length; i++){
                sum = sum + gas[i] - cost[i];
                if(sum < 0){
                    break;
                }
            }
            if(sum < 0){
                continue;
            }
            for(int i = 0; i < index; i++){
                sum = sum + gas[i] - cost[i];
                if(sum < 0){
                    break;
                }
            }
            if(sum >= 0){
                return index;
            }

        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost){
        //开始点
        int startIndex = 0;
        //额外耗费的总油量
        int totalExtraCost = 0;
        //从起始点出发的 额外耗油量
        int currStartExtra = 0;

        for(int i =0; i < gas.length; i++){

            int extraCost = cost[i] - gas[i];
            //加到总的额外耗油量
            totalExtraCost = totalExtraCost + extraCost;
            //开始的额外耗油量
            currStartExtra = currStartExtra + extraCost;
            //如果额外耗油量大于0的话，证明不够了，重置开始节点和开始的额外耗油量
            if(currStartExtra > 0){
                startIndex = i + 1;
                currStartExtra = 0;
                continue;
            }

        }
        //总的额外耗油量大于0，那就不可能达到了
        if(totalExtraCost > 0){
            return -1;
        }else{
            return startIndex;
        }
    }

    public static void main(String[] args) {
//        int[] gas = new int[]{1,2,3,4,5};
//
//        int[] cost = new int[]{3,4,5,1,2};

//        int[] gas = new int[]{2,3,4};
//        int[] cost = new int[]{3,4,3};
        int[] gas = new int[]{5,1,2,3,4};
        int[] cost = new int[]{4,4,1,5,1};

        System.out.println(new Solution134().canCompleteCircuit1(gas,cost));

    }


}