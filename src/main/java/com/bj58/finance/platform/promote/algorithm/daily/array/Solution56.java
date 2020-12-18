package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Comparator;

/***
 *给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution56 {

    /**
     *  先进行排序
     *  然后找出结果数组的长度
     *
     * **/
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }
        //先对数组进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        //确认数组的长度
        int count = 0;
        //起始值和结束值
        int end = Integer.MIN_VALUE;
        //先确定结果数组的长度
        for(int i =0; i < intervals.length; i++){
            if(intervals[i][0] > end){
                count ++;
                end = intervals[i][1];
                continue;
            }
            end = Math.max(end,intervals[i][1]);
        }
        int[][] resultArray = new int[count][];
        int index = 0;
        int first = 0;
        int second = 0;
        for(int i =0; i < intervals.length; i++){

            if(i == 0){
                first = intervals[0][0];
                second = intervals[0][1];
                resultArray[index] = new int[]{first,second};
                continue;
            }
            if(intervals[i][0] > second){
                index ++;
                first = intervals[i][0];
                second = intervals[i][1];
                resultArray[index] = new int[]{first,second};
                continue;
            }
            second = Math.max(second,intervals[i][1]);
            resultArray[index][1] = second;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        System.out.println(JSONObject.toJSONString(new Solution56().merge(array)));
    }
}
