package com.bj58.finance.platform.promote.algorithm.daily.array;

/***
 *你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 *
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 *
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 *
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 *  
 *
 * 提示：
 *
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/video-stitching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution1024 {

    /***
     *  贪心算法
     *  本题的思路
     *
     *  用一个数组记录 clip[0] < T 的集合中，clip[0] < T,则clip[1] >= T是成立的，则肯定能覆盖
     *
     *  以clip[0] 为索引下标，clip[1]的值为右边界所到的最远地方，
     *  如果clip[0] 相等，则maxn[clip[0]]记录最大右边界
     *
     *  遍历这个maxn[i]
     *
     *
     *
     *
     * ***/
    public int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        //记录每个左端点最长的地方，如果有重复右端点就覆盖了，才想明白，哈哈哈哈哈
        //索引记录第一个字段，值记录能达到最右边的最大右端点
        for(int[] clip : clips){
            if(clip[0] < T){
                maxn[clip[0]] = Math.max(maxn[clip[0]],clip[1]);
            }
        }
        //最左边的区间
        int last = 0;
        //上一个区间
        int pre = 0;
        //所经历的区间数
        int num = 0;

        for(int i = 0; i < T; i++){
            //从0开始遍历，比较last和maxn[i] 的最大值
            last = Math.max(last,maxn[i]);
            //去调中间没有的节点，节点缺失的地方
            if(i == last){
                return -1;
            }
            //i = pre 表示当前已经取到了最优的一个片段，该遍历下一个了
            if (i == pre) {
                num ++;
                pre = last;
            }
        }
        return num;
    }


}
