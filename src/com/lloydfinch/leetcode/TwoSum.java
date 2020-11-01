package com.lloydfinch.leetcode;

import java.util.HashMap;

/**
 * Name: TwoSum
 * Author: lloydfinch
 * Function: TwoSum
 * Date: 2020-06-22 22:07
 * Modify: lloydfinch 2020-06-22 22:07
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    //[2,3,4,5,6] //10
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int surplus = target - nums[i];
            if (hashMap.containsKey(surplus) && hashMap.get(surplus) != i) {
                return new int[]{i, hashMap.get(surplus)};
            }
        }
        return null;
    }

}
