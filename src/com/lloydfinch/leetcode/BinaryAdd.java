package com.lloydfinch.leetcode;

import java.util.LinkedHashMap;

/**
 * Name: BinaryAdd
 * Author: lloydfinch
 * Function: BinaryAdd
 * Date: 2020-06-23 09:06
 * Modify: lloydfinch 2020-06-23 09:06
 */
public class BinaryAdd {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum = carry; //如果上次有进位，需要带到本轮

            //处理长度不同引起的差异
            if (i >= 0) sum += a.charAt(i) - '0';
            else sum += 0;

            if (j >= 0) sum += b.charAt(j) - '0';
            else sum += 0;

            //末位
            sb.append(sum % 2);
            //进位
            carry = sum / 2;
        }
        //最后一个进位
        if (carry == 1) sb.append(carry);

        return sb.reverse().toString();
    }
}
