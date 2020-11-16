package com.bj58.finance.platform.promote.algorithm.daily.array;

/**
 *  给出一个无重叠的 ，按照区间起始端点排序的区间列表。
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
 * */
public class Solution57 {


    public int[][] insert(int[][] intervals, int[] newInterval) {
         //intervals 判空
        if(intervals == null || intervals.length <= 0){
            return new int[][]{newInterval};
        }
        //newInterval 判空
        if(newInterval == null || newInterval.length <= 0){
            return intervals;
        }
        //二维数组得长度
        int length = intervals.length;
        //首尾特殊处理，第一个值大于最大值
        if(newInterval[0] > intervals[length - 1][1]){
            int[][] returnArray = new int[length + 1][2];
            returnArray[length] = newInterval;
            for(int i =0; i < length; i++){
                returnArray[i] = intervals[i];
            }
            return returnArray;
        }

        if(newInterval[1] < intervals[0][0]){
            int[][] returnArray = new int[length + 1][2];
            returnArray[0] = newInterval;
            for(int i = 1; i <= length; i++  ){
                returnArray[i] = intervals[i - 1];
            }
            return returnArray;
        }
        //在newInterval[0]之前有几个数组
        int beforeSize = 0;
        int afterSize = 0;

        for(int i = 0; i< length; i++){
            if(intervals[i][1] < newInterval[0]){
                beforeSize = beforeSize  + 1;
            }
            if(intervals[i][0] >newInterval[1] ){
                afterSize = afterSize + 1;
            }
        }
        //中间部分
        int middleSize = 0;
        int beforeFirstData = intervals[beforeSize][0];
        int afterSecondData = intervals[length-1- afterSize][1];

        int[][] resultArray = new int[beforeSize + afterSize + 1 ][2];
        for(int i = 0; i < beforeSize; i++ ){
            resultArray[i] = intervals[i];
        }
        if(beforeFirstData > newInterval[1] || afterSecondData < newInterval[0]){
            resultArray[beforeSize]  = newInterval;
        }
        if(newInterval[0] < beforeFirstData ){
            resultArray[beforeSize][0] = newInterval[0];
        }else{
            resultArray[beforeSize][0] = beforeFirstData;
        }

        if(newInterval[1] < afterSecondData ){
            resultArray[beforeSize][1] = afterSecondData;
        }else{
            resultArray[beforeSize][1] = newInterval[1];
        }

        for( int i = beforeSize + 1; i < resultArray.length; i++){
            resultArray[i] = intervals[length - 1 -afterSize + i - beforeSize];
        }
        return resultArray;
    }

    public static void main(String[] args) {

        int[][] array = new int[][]{{1,5}};

        int[] array1 = new int[]{6,8};

        int[][] result = new Solution57().insert(array,array1);

        System.out.println(result);

    }


}
