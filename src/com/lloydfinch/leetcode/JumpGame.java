package com.lloydfinch.leetcode;

/**
 * Name: JumpGame
 * Author: lloydfinch
 * Function: JumpGame，跳跃游戏
 * Date: 2020-06-02 21:44
 * Modify: lloydfinch 2020-06-02 21:44
 */
public class JumpGame {
    //倒序贪心
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        int endable = nums.length - 1; //最终需要跑到这里
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endable) { //第i个位置可以到终点
                endable = i; //那么就倒退到第i个位置继续向前探
            }
        }
        return endable == 0;
    }

    //正序贪心 TODO 看官方答案实现
    public boolean canJump2(int[] nums) {
        if (nums == null) return false;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + i >= end) { //第i个位置可以到达

            }
        }

        return false;
    }
}
