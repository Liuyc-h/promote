package com.bj58.finance.platform.promote.algorithm.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
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
 * 提示：
 *
 * intervals[i][0] <= intervals[i][1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution56 {

    public int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }

        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        //以第一个元素为引
        int[] flowArray = intervals[0];
        for(int i= 1; i < intervals.length; i++){
            //全部在flowArray之后
            if(intervals[i][0] >flowArray[1]){
                resultList.add(new int[]{flowArray[0],flowArray[1]});
                flowArray = intervals[i];
                continue;
            }
            flowArray[0] = Math.min(flowArray[0],intervals[i][0]);
            flowArray[1] = Math.max(flowArray[1],intervals[i][1]);
        }
        resultList.add(flowArray);
        return resultList.toArray(new int[resultList.size()][]);
    }
}
