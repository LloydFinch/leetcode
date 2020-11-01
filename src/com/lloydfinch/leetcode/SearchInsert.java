package com.lloydfinch.leetcode;

import java.util.Arrays;

/**
 * Name: SearchInsert
 * Author: lloydfinch
 * Function: SearchInsert
 * Date: 2020-07-18 07:11
 * Modify: lloydfinch 2020-07-18 07:11
 */
public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;
        int index = searchInsert.searchInsert(nums, target);

        System.out.println(index);
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) return start;
        int mid = (start + end) / 2;
        if (target == nums[mid]) return mid;
        if (target > nums[mid]) return binarySearch(nums, target, mid + 1, end);
        return binarySearch(nums, target, start, mid - 1);
    }
}
