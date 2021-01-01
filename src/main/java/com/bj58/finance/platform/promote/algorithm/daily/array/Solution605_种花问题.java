package com.bj58.finance.platform.promote.algorithm.daily.array;


/***
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * **/
public class Solution605_种花问题 {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed == null || flowerbed.length == 0){
            return false;
        }
        //长度为1特殊处理
        if(flowerbed.length == 1){
            int result = flowerbed[0] == 0 ? 1 : 0;
            return result >= n ? true : false;
        }
        int length = flowerbed.length ;
        int result = 0;
        //定义一个滑动索引，判断当前节点为0，上个节点也为0得时候，上个节点是不是已经被种过了
        int slideIndex = -1;
        for(int i = 0; i< flowerbed.length - 1; i++){
            //第0个 只需要判断一个就行了，如果是可以，加1，滑动索引也加1
            if(i == 0 ){
                if( flowerbed[i + 1] != 1 && flowerbed[0] == 0){
                    result ++;
                    slideIndex = i;
                }
                continue;
            }
            //前后不为1，当前为0，且上一个为0得没有种得，结果加1，滑动索引等于当前索引下标
            if(flowerbed[i + 1] != 1 && flowerbed[i - 1] != 1 && slideIndex != i - 1
                      && flowerbed[i] == 0 ){
                result ++;
                slideIndex = i;
            }
        }
        //长度大于1得时候判断下最后一位得索引
        if(length > 1 && flowerbed[length - 1] == 0
                && flowerbed[length - 2] != 1 && slideIndex != (length -2) ){
            result ++;
        }
        return result >= n ? true : false;
    }

    public static void main(String[] args) {

    }
}
