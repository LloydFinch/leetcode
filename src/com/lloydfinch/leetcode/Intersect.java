package com.lloydfinch.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Name: Intersect
 * Author: lloydfinch
 * Function: Intersect
 * Date: 2020-07-13 22:46
 * Modify: lloydfinch 2020-07-13 22:46
 */
public class Intersect {

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] ints = intersect.intersect(nums1, nums2);
    }

    /**
     * 求两个数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        //认为第一个参数为较小参数
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        //使用hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        //取较小的数组长度
        int[] intersect = new int[nums1.length];
        int index = 0;
        for (int value : nums2) {
            int count = map.getOrDefault(value, 0);
            if (count > 0) {
                intersect[index++] = value;
            }
            if ((count--) > 0) map.put(value, count);
            else map.remove(value);
        }
        //copy出子集
        return Arrays.copyOfRange(intersect, 0, index);
    }


    private void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
