package com.lloydfinch.leetcode;

/**
 * Name: ArrayToBinary
 * Author: lloydfinch
 * Function: ArrayToBinaryTree，有序数组转换为高度平衡的二叉搜索树
 * Date: 2020-07-03 08:17
 * Modify: lloydfinch 2020-07-03 08:17
 */
public class ArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }


    private TreeNode divide(int[] nums, int start, int end) {
        if (start < end) return null;
        int mid = (start + end) / 2;
        // int mid = (start + end + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = divide(nums, start, mid - 1);
        root.right = divide(nums, mid + 1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
