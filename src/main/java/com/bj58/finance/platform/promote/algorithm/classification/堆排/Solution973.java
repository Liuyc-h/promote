package com.bj58.finance.platform.promote.algorithm.classification.堆排;

import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution973 {

    /***
     *
     *  利用优先级队列进行排序，取得前k和数即可
     * **/
    public int[][] kClosest(int[][] points, int K){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1];
            }
        });

        for(int i =0 ; i< points.length; i++){
            priorityQueue.offer(points[i]);
        }
        int[][] resultArray = new int[K][];
        for(int i = 0; i< K; i++){
            resultArray[i] = priorityQueue.poll();
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,3},{-2,2}};

        System.out.println(JSONObject.toJSONString(new Solution973().kClosest(array,1)));
    }
}
