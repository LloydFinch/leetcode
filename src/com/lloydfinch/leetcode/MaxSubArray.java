package com.lloydfinch.leetcode;

/**
 * Name: MaxSubArray
 * Author: lloydfinch
 * Function: MaxSubArray
 * Date: 2020-06-22 23:13
 * Modify: lloydfinch 2020-06-22 23:13
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray max = new MaxSubArray();
        int nums[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(max.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) dp[i] = dp[i - 1] + nums[i];
            else dp[i] = nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
