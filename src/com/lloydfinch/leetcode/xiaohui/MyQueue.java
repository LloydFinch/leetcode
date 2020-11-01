package com.lloydfinch.leetcode.xiaohui;

/**
 * Name: MyQueue
 * Author: lloydfinch
 * Function: MyQueue，用数组实现的"循环队列"
 * Date: 2020-07-04 22:12
 * Modify: lloydfinch 2020-07-04 22:12
 */
public class MyQueue {
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 要入队的元素
     * @return 是否成功入队
     */
    public boolean enQueue(int element) {
        //判断队列是否已满
        if ((rear + 1) % array.length == front) return false;

        //插入队尾
        array[rear] = element;
        //更新队尾指针，一般只要rear++就行，但是循环队列，需要做循环处理
        rear = (rear + 1) % array.length;

        return true;
    }

    /**
     * 出队
     *
     * @return 出队的元素
     * @throws IllegalStateException 如果队列为空，则抛出异常
     */
    public int deQueue() throws IllegalStateException {
        //判断队列是否为空
        if (front == rear) throw new IllegalStateException("Queue is empty");

        //队头出队
        int element = array[front];
        //更新队头指针，一般只要后移(front++)即可，但是循环队列，需要做循环处理
        front = (front + 1) % array.length;

        return element;
    }

    /**
     * 打印队列元素
     * 这个for循环很巧妙
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i] + ", ");
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(4);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.deQueue();
        myQueue.enQueue(4);
        boolean enQueue = myQueue.enQueue(5);
        System.out.println("enqueue 5? " + enQueue);
        myQueue.output();

        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        int deQueue = myQueue.deQueue();
        // System.out.println(deQueue);
        myQueue.deQueue();
    }
}
