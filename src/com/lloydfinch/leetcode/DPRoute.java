package com.lloydfinch.leetcode;

import java.util.Arrays;

/**
 * Name: DPRoute
 * Author: lloydfinch
 * Function: DPRoute，m*n 左上角到达右下角有几种走法
 * Date: 2020-06-22 14:55
 * Modify: lloydfinch 2020-06-22 14:55
 */
public class DPRoute {

    public static void main(String[] args) {
        DPRoute dp = new DPRoute();
        int m = 7, n = 3;
        int path = dp.uniquePaths(m, n);
        System.out.println(path);
    }

    private int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
