package com.lloydfinch.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: InOrderTraversal
 * Author: lloydfinch
 * Function: InOrderTraversal，二叉树的中序遍历 左根右
 * Date: 2020-06-01 21:25
 * Modify: lloydfinch 2020-06-01 21:25
 */
public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(nodes, root);
        return nodes;
    }

    private void traversal(List<Integer> nodes, TreeNode root) {
        if (root == null) return;
        if (root.left != null) traversal(nodes, root.left);
        nodes.add(root.val);
        if (root.right != null) traversal(nodes, root.right);
    }
}
