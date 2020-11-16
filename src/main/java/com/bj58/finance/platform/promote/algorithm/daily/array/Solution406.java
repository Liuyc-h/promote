package com.bj58.finance.platform.promote.algorithm.daily.array;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *  假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution406 {

    // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
    // 再一个一个插入。
    // [7,0]
    // [7,0], [7,1]
    // [7,0], [6,1], [7,1]
    // [5,0], [7,0], [6,1], [7,1]
    // [5,0], [7,0], [5,2], [6,1], [7,1]
    // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
    public int[][] reconstructQueue(int[][] people){

        //先进行排序，逆序排，如果首元素相等，按照第二个元素升序排列
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        //定义一个LinkedList，按照索引插入数组
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] i : people){
            list.add(i[1],i);
        }
        //最后转换为数组即可
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {

        int[][] array = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        int[][] resultArray = new Solution406().reconstructQueue(array);

        System.out.println(JSONObject.toJSONString(resultArray));
    }
}
