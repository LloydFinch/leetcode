package com.lloydfinch.leetcode;

/**
 * Name: FindLength
 * Author: lloydfinch
 * Function: FindLength，找两个数组的最大公共子数组
 * Date: 2020-07-01 22:42
 * Modify: lloydfinch 2020-07-01 22:42
 */
public class FindLength {

    public static void main(String[] args) {
        FindLength findLength = new FindLength();
        int[] A = new int[]{1, 2, 3, 2, 1, 4, 5, 6, 7, 8, 9};
        int[] B = new int[]{3, 2, 1, 4, 7, 5, 6, 7, 8};
        int max = findLength.findLength(A, B);
        System.out.println(max);
    }

    //使用动态规划
    public int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        int[][] dp = new int[a + 1][b + 1];
        int max = 0;
        for (int i = a - 1; i >= 0; i--) {
            for (int j = b - 1; j >= 0; j--) {
                if (A[i] == B[j]) dp[i][j] = dp[i + 1][j + 1] + 1;
                else dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
