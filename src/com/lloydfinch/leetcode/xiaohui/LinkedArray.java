package com.lloydfinch.leetcode.xiaohui;

/**
 * Name: LinkedArray
 * Author: lloydfinch
 * Function: LinkedArray
 * Date: 2020-07-02 22:34
 * Modify: lloydfinch 2020-07-02 22:34
 */
public class LinkedArray {
    private int size;
    private Node head;
    private Node last;

    public void insert(int data, int index) {
        check(index);

        Node newNode = new Node(data);
        if (size == 0) {
            //空链表
            head = newNode;
            last = newNode;
        } else if (index == 0) {
            //插入头部
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            //插入尾部
            last.next = newNode;
            last = newNode;
        } else {
            //插入中间

            //前一个节点
            Node pre = get(index);
            //新节点指向原节点的next
            newNode.next = pre.next;
            //原节点的next指向新节点
            pre.next = newNode;
        }
        size++;
    }

    public Node remove(int index) {
        check(index);
        Node remove = get(index);
        if (index == 0) {
            //删除头 此时remove就是head节点
            head.next = remove.next;
        } else if (index == size) {
            //删除尾部 此时remove就是last
            Node pre = get(index - 1);
            pre.next = null;
        } else {
            //删除中间
            Node pre = get(index - 1);
            pre.next = remove.next;
        }
        size--;
        return remove;
    }

    private void check(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void traversal() {
        Node node = head;
        while (node != null) {
            System.out.println(node.data + ", ");
            node = node.next;
        }
    }

    /**
     * 查找第index个节点
     *
     * @param index 下标
     * @return Node
     */
    public Node get(int index) {
        check(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedArray linkedArray = new LinkedArray();
        linkedArray.insert(0, 0);
        linkedArray.insert(1, 1);
        linkedArray.insert(2, 2);
        linkedArray.insert(3, 3);
        linkedArray.insert(4, 4);
        linkedArray.insert(5, 5);
        linkedArray.insert(6, 6);
        linkedArray.insert(7, 7);
        linkedArray.insert(8, 8);
        linkedArray.insert(9, 9);
        linkedArray.insert(10, 10);


        linkedArray.remove(4);

        linkedArray.traversal();
    }
}
