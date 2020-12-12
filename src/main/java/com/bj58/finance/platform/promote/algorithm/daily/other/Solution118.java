package com.bj58.finance.platform.promote.algorithm.daily.other;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> resultList = new ArrayList<>();

        if(numRows == 0){
            return resultList;
        }
        resultList.add(Arrays.asList(1));
        for(int i = 2; i<= numRows; i++){

            List<Integer> list = new ArrayList<>();

            List<Integer> lastList = resultList.get(i - 2);

            for(int j = 0; j < i; j++){
                if(j ==  0 || j == i - 1){
                    list.add(1);
                    continue;
                }
                int currInt = lastList.get(j - 1) + lastList.get(j);
                list.add(currInt);
            }
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Solution118().generate(5)));
    }
}
