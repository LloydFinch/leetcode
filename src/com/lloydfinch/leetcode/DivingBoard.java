package com.lloydfinch.leetcode;

/**
 * Name: DivingBoard
 * Author: lloydfinch
 * Function: DivingBoard  面试题16.11
 * Date: 2020-07-08 22:00
 * Modify: lloydfinch 2020-07-08 22:00
 */
public class DivingBoard {

    public static void main(String[] args) {

    }


    public int[] divingBoard(int shorter, int longer, int k) {
        //如果k==0，就返回空数组
        if (k == 0) return new int[]{};

        //如果长度相同，只有一种跳法
        if (shorter == longer) return new int[]{shorter * k};

        int[] lengths = new int[k + 1]; //0个k到k个k，共k+1种
        //优先选择长的，剩下的就是短的
        for (int i = 0; i <= k; i++) {
            lengths[i] = longer * i + shorter * (k - i);
        }
        return lengths;
    }

}
