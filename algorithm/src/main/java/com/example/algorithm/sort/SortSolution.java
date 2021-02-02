package com.example.algorithm.sort;

public class SortSolution {

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n < 1) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int num = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = num;
                }
            }
        }
        return;
    }

    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    // 选择排序，a表示数组，n表示数组大小
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void mergeSort(int[] a, int n) {
        mergeSort(a, 0, n - 1);
        return;
    }

    static void mergeSort(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }


    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }
}
