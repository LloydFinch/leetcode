package com.lloydfinch.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Name: NQueues
 * Author: lloydfinch
 * Function: NQueues，N皇后问题
 * Date: 2020-06-03 22:14
 * Modify: lloydfinch 2020-06-03 22:14
 */
public class NQueues {

    int rows[];
    int hills[];
    int dales[];
    int n;
    List<List<String>> output = new ArrayList();
    int queens[];

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;  // "hill" diagonals
        dales[row + col] = 1;   //"dale" diagonals
    }

    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for (int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) addSolution();
                else backtrack(row + 1);
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }


    public static void main(String[] args) {
        // NQueues nQueues = new NQueues();
        // List<List<String>> lists = nQueues.solveNQueens(4);

        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        lists.forEach(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) {
                strings.forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });
                System.out.println();
            }
        });
    }


    ///N皇后问题注释版本
    static class Solution {
        private List<List<String>> output = new ArrayList<>();

        // 用于标记是否被列方向的皇后攻击
        int[] rows;
        // 用于标记是否被主对角线方向的皇后攻击
        int[] mains;
        // 用于标记是否被次对角线方向的皇后攻击
        int[] secondary;
        // 用于存储皇后放置的位置
        int[] queens;

        int n;

        public List<List<String>> solveNQueens(int n) {
            // 初始化
            rows = new int[n];
            mains = new int[2 * n - 1];
            secondary = new int[2 * n - 1];
            queens = new int[n];
            this.n = n;

            // 从第一行开始回溯求解 N 皇后
            backtrack(0);

            return output;
        }

        // 在一行中放置一个皇后
        private void backtrack(int row) {
            if (row >= n) return;
            // 分别尝试在 row 行中的每一列中放置皇后
            for (int col = 0; col < n; col++) {
                // 判断当前放置的皇后不被其他皇后的攻击
                if (isNotUnderAttack(row, col)) {
                    // 选择，在当前的位置上放置皇后
                    placeQueen(row, col);
                    // 当当前行是最后一行，则找到了一个解决方案
                    if (row == n - 1) addSolution();
                        // 在下一行中放置皇后
                    else backtrack(row + 1);
                    // 撤销，回溯，即将当前位置的皇后去掉
                    removeQueen(row, col);
                }
            }
        }

        // 判断 row 行，col 列这个位置有没有被其他方向的皇后攻击
        private boolean isNotUnderAttack(int row, int col) {
            // 判断的逻辑是：
            //      1. 当前位置的这一列方向没有皇后攻击
            //      2. 当前位置的主对角线方向没有皇后攻击
            //      3. 当前位置的次对角线方向没有皇后攻击
            int res = rows[col] + mains[row - col + n - 1] + secondary[row + col];
            // 如果三个方向都没有攻击的话，则 res = 0，即当前位置不被任何的皇后攻击
            return res == 0;
        }

        // 在指定的位置上放置皇后
        private void placeQueen(int row, int col) {
            // 在 row 行，col 列 放置皇后
            queens[row] = col;
            // 当前位置的列方向已经有皇后了
            rows[col] = 1;
            // 当前位置的主对角线方向已经有皇后了
            mains[row - col + n - 1] = 1;
            // 当前位置的次对角线方向已经有皇后了
            secondary[row + col] = 1;
        }

        // 移除指定位置上的皇后
        private void removeQueen(int row, int col) {
            // 移除 row 行上的皇后
            queens[row] = 0;
            // 当前位置的列方向没有皇后了
            rows[col] = 0;
            // 当前位置的主对角线方向没有皇后了
            mains[row - col + n - 1] = 0;
            // 当前位置的次对角线方向没有皇后了
            secondary[row + col] = 0;
        }

        /**
         * 将满足条件的皇后位置放入output中
         */
        public void addSolution() {
            List<String> solution = new ArrayList<String>();
            for (int i = 0; i < n; ++i) {
                int col = queens[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < col; ++j) sb.append(".");
                sb.append("Q");
                for (int j = 0; j < n - col - 1; ++j) sb.append(".");
                solution.add(sb.toString());
            }
            output.add(solution);
        }
    }

    public void doIfNotNull(Object obj, Runnable runnable) {
        if (obj != null) {
            runnable.run();
        }
    }
}
