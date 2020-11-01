package com.lloydfinch.leetcode;

import java.util.TreeMap;

import javax.print.attribute.standard.JobSheets;

/**
 * Name: Test
 * Author: lloydfinch
 * Function: Test
 * Date: 2020-06-22 14:30
 * Modify: lloydfinch 2020-06-22 14:30
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.fac(5));

        TreeMap<String, String> map = new TreeMap<>();
        map.put("hello", "world");
    }

    /**
     * 求n的阶乘
     *
     * @param n
     * @return
     */
    private int fac(int n) {
        return n <= 1 ? n : n * fac(n - 1);
    }

    private void testFor() {
    }
}
