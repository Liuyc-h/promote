package com.bj58.finance.platform.promote.algorithm.again;

import java.util.ArrayList;
import java.util.List;

/***
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *  
 *
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval){

        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }
        if(newInterval == null){
            return intervals;
        }
        //结果
        List<int[]> resultList = new ArrayList<>();
        boolean flag = false;
        for(int i = 0; i< intervals.length; i++){
            //如果已经插入或者没有插入。但是整体在新插入的前面，则直接插入
            if(flag || intervals[i][1] < newInterval[0]){
                resultList.add(intervals[i]);
                continue;
            }
            //未插入，但是整个在当前元素之前，所以直接插入即可
            if(!flag && intervals[i][0] > newInterval[1]){
                resultList.add(new int[]{newInterval[0],newInterval[1]});
                resultList.add(intervals[i]);
                flag = true;
                continue;
            }
            //不符合以上情况，且为插入，重置newInterval
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
        }
        if(!flag){
            resultList.add(newInterval);
        }
        return resultList.toArray(new int[resultList.size()][]);

    }
}
