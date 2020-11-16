package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.*;

/**
 *  有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution841 {

    /**
     *  广度优先
     *  目的是从一个房间拿到下一个房间得钥匙，最终达到所有房间
     * **/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if(rooms == null || rooms.size() <= 0){
            return false;
        }
        int length = rooms.size();
        //定义一个布尔数组。来标识已经去过和未去过得房间
        boolean[] visit = new boolean[length];
        //队列，先进先出
        Queue<Integer> queue = new LinkedList<>();
        //0号房间先置为true
        int num = 0;
        visit[0] = true;
        queue.offer(0);

        while(!queue.isEmpty()){
            int index = queue.poll();
            num ++;
            //从0号房间拿到其他房间得钥匙
            for(int arr : rooms.get(index)){
                if(!visit[arr]){
                    //如果拿到，赋为true，进入队列
                    visit[arr] = true;
                    queue.offer(arr);
                }
            }
        }
        return num == length;
    }

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 0, 0, 0);

        List<Integer> list2 = Arrays.asList(0, 0, 0, 2);

        List<Integer> list3 = Arrays.asList(0, 3, 0, 0);
        List<Integer> list4 = Arrays.asList(0, 0, 0, 0);

//        List<Integer> list4 = new ArrayList<>();

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);

        System.out.println(new Solution841().canVisitAllRooms(rooms));
    }


}
