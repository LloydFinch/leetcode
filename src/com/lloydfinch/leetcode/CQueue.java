package com.lloydfinch.leetcode;

import java.util.Stack;

/**
 * Name: CQueue
 * Author: lloydfinch，使用两个stack模拟一个queue
 * Function: CQueue
 * Date: 2020-06-30 23:25
 * Modify: lloydfinch 2020-06-30 23:25
 */
public class CQueue {


    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(100);
        System.out.println(queue.deleteHead());

        queue.appendTail(101);
        queue.appendTail(102);
        queue.appendTail(103);
        System.out.println(queue.deleteHead());
    }

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public CQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void appendTail(int value) {
        stackPush.push(value);
    }

    public int deleteHead() {
        //如果pop栈还没有元素，就将所有元素倒腾入pop栈
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

        if (stackPop.isEmpty()) {
            return -1;
        }
        return stackPop.pop();
    }

}
