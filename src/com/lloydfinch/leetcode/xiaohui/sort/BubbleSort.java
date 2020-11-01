package com.lloydfinch.leetcode.xiaohui.sort;

/**
 * Name: BobleSort
 * Author: lloydfinch
 * Function: BobleSort
 * Date: 2020-07-09 22:52
 * Modify: lloydfinch 2020-07-09 22:52
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        print(arr);
        sort.cocktailSort(arr);

        System.out.println();
        System.out.println("==============================================================");
        print(arr);
    }

    /**
     * 常规冒泡排序
     */
    public void sort(int[] arr) {
        int len = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //这里是个优化点 arr.length - 1 - i(因为后i个已经有序了)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
                len++;
            }
        }
        System.out.println("    len = " + len);
    }

    /**
     * 优化的冒泡，如果已经有序，则直接跳过
     */
    public void sortOpt(int[] arr) {
        int len = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 如果有过交换，就是没排好
                    isSorted = false;
                }
                len++;
            }
            if (isSorted) {
                break;
            }
        }

        System.out.println("    len = " + len);
    }

    /**
     * 冒泡二级优化，记录有序区边界，只比较无序部分
     */
    public void sortOpt2(int[] arr) {
        int len = 0;
        int sortedBorder = arr.length - 1;
        int exchange = 0; //默认为0，如果没交换过，说明直接有序，不需要排了
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            //这里记录一下每次最后交换元素的位置
            for (int j = 0; j < sortedBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                    exchange = j;
                }
                len++;
            }
            //更新边界
            sortedBorder = exchange;

            if (isSorted) {
                break;
            }
        }

        System.out.println("    len = " + len);
    }

    /**
     * 鸡尾酒排序
     * 双端轮流冒泡，防止出现极限情况(eg: 2,3,4,5,6,7,8,1)
     */
    public void cocktailSort(int[] arr) {
        int len = 0;
        int sortedBorder = arr.length - 1;
        int exchange = 0;

        //正方向来一次
        for (int i = 0; i < arr.length - 1; i++) {

            //奇数轮:从前向后
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                    len++;
                }
            }
            if (isSorted) {
                break;
            }

            //偶手轮:从后向前
            isSorted = true;
            for (int j = arr.length - 1 - i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSorted = false;
                    len++;
                }
            }
            if (isSorted) {
                break;
            }
        }

        System.out.println("    len = " + len);
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
