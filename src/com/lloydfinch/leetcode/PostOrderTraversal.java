package com.lloydfinch.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: PostOrderTraversal
 * Author: lloydfinch
 * Function: PostOrderTraversal，二叉树后序遍历，左右根
 * Date: 2020-06-01 22:25
 * Modify: lloydfinch 2020-06-01 22:25
 */
public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(nodes, root);
        return nodes;
    }

    private void traversal(List<Integer> nodes, TreeNode root) {
        if (root == null) return;
        if (root.left != null) traversal(nodes, root.left);
        if (root.right != null) traversal(nodes, root.right);
        nodes.add(root.val);
    }
}
