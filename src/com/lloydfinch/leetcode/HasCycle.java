package com.lloydfinch.leetcode;

/**
 * Name: HasCycle
 * Author: lloydfinch
 * Function: HasCycle
 * Date: 2020-07-18 07:52
 * Modify: lloydfinch 2020-07-18 07:52
 */
public class HasCycle {

    /**
     * 判断链表是否有环
     * 快慢指针法
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //相遇了
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
