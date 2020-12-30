package com.bj58.finance.platform.promote.algorithm.daily.array;

import java.util.PriorityQueue;

/***
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为
 *  x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *  
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * 通过次数30,532提交次数48,119
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution1046 {

    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }
        int[] array = new int[1001];
        for(int i = 0; i < stones.length; i++){
            array[stones[i]] ++;
        }
        int count = stones.length;
        int slideIndex = 1000;
        while(count > 1 && slideIndex > 0){
            int index = slideIndex;
            int x = 0,y=0;
            for(int i = index; i>= 0;i--){
                if(array[i] == 0 && x == 0) {
                    slideIndex = i;
                    continue;
                }
                if(x != 0 && array[i] > 0){
                    y = i;
                    array[i] = array[i] - 1;
                    break;
                }
                if(array[i] == 1){
                    x = i;
                    array[i] = array[i] - 1;
                }else if(array[i] > 1){
                    x = i;
                    y = i;
                    array[i] = array[i] - 2;
                }
                if(x >0 && y > 0){
                    break;
                }
            }
            if(x == y){
                count = count - 2;
            }else{
                count = count - 1;
                array[x - y] ++;
            }
        }
        if(count == 0){
            return 0;
        }else{
            for(int i = slideIndex; i>= 0; i--){
                if(array[i] > 0){
                    return i;
                }
            }
        }
        return 0;
    }


    public int lastStoneWeight1(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }


    public static void main(String[] args) {
        int[] array = new int[]{2,7,4,1,8,1};

        System.out.println(new Solution1046().lastStoneWeight1(array));
    }
}
