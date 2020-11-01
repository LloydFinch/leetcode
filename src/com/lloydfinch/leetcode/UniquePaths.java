package com.lloydfinch.leetcode;

/**
 * Name: UniquePaths
 * Author: lloydfinch
 * Function: UniquePaths
 * Date: 2020-07-07 23:25
 * Modify: lloydfinch 2020-07-07 23:25
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
