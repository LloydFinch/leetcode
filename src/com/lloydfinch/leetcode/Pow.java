package com.lloydfinch.leetcode;

/**
 * Name: Pow
 * Author: lloydfinch
 * Function: 模拟x的次幂
 * Date: 2020-05-25 22:59
 * Modify: lloydfinch 2020-05-25 22:59
 */
public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        double result = pow.myPow(2.0, -2);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        int temp = n > 0 ? n : -n;
        double result = 1.0d;
        if (n == 0) {
            return 1.0d;
        }
        result = myPow(x, temp / 2);
        if (n % 2 == 1.0d) {
            result = result * result * x;
        } else {
            result = result * result;
        }

        if (n > 0) {
            return result;
        } else {
            return 1.0d / result;
        }
    }
}
