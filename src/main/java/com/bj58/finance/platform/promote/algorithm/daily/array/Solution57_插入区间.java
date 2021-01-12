package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;
import com.bj58.finance.platform.promote.algorithm.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution57_插入区间 {

    /***
     *
     *
     * **/
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> resultList = new ArrayList<>();
        //数组是否插入的标志
        Boolean insertFlag = false;
        for(int i = 0; i< intervals.length; i++){
             //在此之前的可以先插入，不用管
            if(intervals[i][1] < newInterval[0]){
                resultList.add(intervals[i]);
                continue;
            }
            //如果没插入，且都在数组该元素之前，则先插入newInterval，再插入intervals[i]
            if(!insertFlag && intervals[i][0] > newInterval[1]){
                resultList.add(newInterval);
                resultList.add(intervals[i]);
                insertFlag = true;
                continue;
            }
            //如果已经插入，则不需比较了，后面的直接插入即可
            if(insertFlag){
                resultList.add(intervals[i]);
            }else{//未插入的话，比较大小填充值
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        //如果未插入的话，插入一下
        if(!insertFlag){
            resultList.add(newInterval);
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};

        int[] array1 = new int[]{4,8};

        int[][] result = new Solution57_插入区间().insert(array,array1);

        System.out.println(JSONObject.toJSONString(result));
    }
}
