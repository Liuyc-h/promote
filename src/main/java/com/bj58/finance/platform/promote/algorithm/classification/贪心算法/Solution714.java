package com.bj58.finance.platform.promote.algorithm.classification.贪心算法;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 6, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution714 {
    /**
     *  贪心算法
     *
     *  本题的思路
     *  从0开始，记录买入股票所花的钱 buy = prices[0] + fee
     *
     *  从1开始遍历数组prices[i]
     *     如果  prices[i] + fee < buy,证明此时买入的代价更低，则更新buy
     *
     *     如果 prices[i] > buy,则证明此时卖出能赚钱，则卖出
     *       buy更新为prices[i],如果下一个数大于prices[i],则可以直接算收益，相当于在i天啥也没做
     *     如果 buy - fee <=prices[i] <= buy
     *        此时不赚钱，不能抛出
     * **/
    public int maxProfit(int[] prices, int fee) {
        //收益
        int profit = 0;
        //数组长度
        int length = prices.length;
        //买入的钱
        int buy = prices[0] + fee;
        for(int i = 1; i< length; i++){
            //如果遍历到当前买入的值 + fee 小于buy的，只需更新buy即可
            //此时  buy = prices[i - 1]，price[i] >= price[i - 1] - fee,此时买入会赔，所以此时不做买入操作
            if(prices[i] + fee < buy){
                buy = prices[i] + fee;
            }else if(prices[i] > buy){//如果当前的钱大于buy的话，算收益
                //此时更新buy为prices[i],如果下一天的卖的钱大于昨天的话，
                //收益正好是今天 - 昨天的钱，相当于昨天什么也没做，卧槽，好精妙啊
                profit = profit + prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }


    public static void main(String[] args) {

        int[] prices = new int[]{1, 3, 2, 8, 6, 9};

        System.out.println(new Solution714().maxProfit(prices,2));

    }
}
