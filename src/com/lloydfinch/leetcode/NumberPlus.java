package com.lloydfinch.leetcode;

/**
 * Name: NumberPlus
 * Author: lloydfinch
 * Function: NumberPlus
 * Date: 2020-08-03 07:06
 * Modify: lloydfinch 2020-08-03 07:06
 */
public class NumberPlus {

    public static void main(String[] args) {
    }

    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;

            int sum = n1 + n2 + carry;
            int res = sum % 10;
            carry = sum / 10;
            sb.append(res);

            l1--;
            l2--;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
