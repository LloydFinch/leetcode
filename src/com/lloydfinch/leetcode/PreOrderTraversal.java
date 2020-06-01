package com.lloydfinch.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: PreOrderTraversal
 * Author: lloydfinch
 * Function: PreOrderTraversal，二叉树的先序遍历，根左右
 * Date: 2020-06-01 22:12
 * Modify: lloydfinch 2020-06-01 22:12
 */
public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(nodes, root);
        return nodes;
    }

    private void traversal(List<Integer> nodes, TreeNode root) {
        if (root == null) return;
        nodes.add(root.val);
        if (root.left != null) traversal(nodes, root.left);
        if (root.right != null) traversal(nodes, root.right);
    }
}
