package com.lloydfinch.leetcode.xiaohui;

/**
 * Name: ArrayInsert
 * Author: lloydfinch
 * Function: ArrayInsert
 * Date: 2020-06-29 23:40
 * Modify: lloydfinch 2020-06-29 23:40
 */
public class ArrayInsert {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        myArray.insert(0, 0);
        myArray.insert(1, 1);
        myArray.insert(2, 2);
        myArray.insert(3, 3);
        System.out.println(myArray.remove(3));
        myArray.insert(3, 3);
        myArray.insert(4, 4);
        myArray.insert(5, 5);
        myArray.insert(6, 6);
        myArray.insert(7, 7);
        myArray.insert(8, 8);
        myArray.insert(9, 9);
        myArray.insert(10, 10);
        myArray.insert(11, 11);
        myArray.insert(12, 12);
        myArray.insert(13, 13);
        myArray.println();
    }

    /**
     * 模拟自定义数组
     */
    public static class MyArray {
        private int[] array;
        private int size;

        public MyArray(int capacity) {
            this.array = new int[capacity];
            this.size = 0;
        }

        /**
         * insert element into array
         *
         * @param element the element
         * @param index   index
         * @throws IndexOutOfBoundsException
         */
        public void insert(int element, int index) throws IndexOutOfBoundsException {
            //check the index
            check(index);

            //如果当前元素已经放满，就扩大数组为原来的两倍
            if (size >= array.length) grow(size << 1);

            //move element to head
            for (int i = size - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }

            //set new element
            array[index] = element;
            size++;
        }

        /**
         * remove element
         *
         * @param index index
         * @return the element removed
         */
        public int remove(int index) {
            check(index);
            int element = array[index];

            //move element to trail
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return element;
        }

        private void grow(int newSize) {
            if (newSize <= size) return;
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        private void check(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
        }

        public void println() {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
