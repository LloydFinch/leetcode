package com.lloydfinch.leetcode.xiaohui;

import java.util.*;

/**
 * Name: DFS
 * Author: lloydfinch
 * Function: DFS
 * Date: 2020-07-08 22:12
 * Modify: lloydfinch 2020-07-08 22:12
 */
public class DFS {

    public static void main(String[] args) {
        DFS dfs = new DFS();
        Integer[] datas = new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4};
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(datas));
        dfs.bfs(createBinaryTree(linkedList));
    }


    /**
     * 中序遍历
     */
    private void inOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        print(root.val);
        if (root.right != null) inOrder(root.right);
    }

    /**
     * 先序遍历
     */
    private void preOrder(TreeNode root) {
        if (root == null) return;
        print(root.val);
        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }

    /**
     * 后序遍历
     */
    private void postOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        print(root.val);
    }

    /**
     * 层序遍历
     * 使用队
     */
    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        //根节点入队
        queue.offer(root);
        //循环遍历根节点
        while (!queue.isEmpty()) {
            //出队，打印节点
            TreeNode node = queue.poll();
            print(node.val);
            //左右孩子入队
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    /**
     * 使用递归创建二叉树
     *
     * @param vals 数值
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> vals) {
        if (vals == null || vals.isEmpty()) return null;
        TreeNode root = null;
        Integer val = vals.removeFirst();
        if (val != null) { //这里的判空等价于判断是不是叶子节点
            root = new TreeNode(val);
            root.left = createBinaryTree(vals);
            root.right = createBinaryTree(vals);
        }
        return root;
    }

    private void print(int val) {
        System.out.println(val);
    }
}
