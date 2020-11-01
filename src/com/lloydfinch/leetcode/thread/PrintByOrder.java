package com.lloydfinch.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Name: PrintByOrder
 * Author: lloydfinch
 * Function: PrintByOrder，依次打印one/two/three
 * Date: 2020-07-01 22:55
 * Modify: lloydfinch 2020-07-01 22:55
 */
public class PrintByOrder {

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        PrintByOrder print = new PrintByOrder();

    }

    public PrintByOrder() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        condition1.signalAll();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        condition1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        condition2.signalAll();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        condition2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}
