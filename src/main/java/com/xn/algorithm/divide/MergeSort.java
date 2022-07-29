package com.xn.algorithm.divide;

public class MergeSort {

    /**
     * 对数组排序，指定起始位置和尾部位置
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int mergeSort(int array[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            merge(array, start, mid, end);
        }
        return 1;
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int tmp[] = new int[array.length];
        int p1 = left;
        int p2 = right;
        int k = left;

        for (; right < array.length;) {
            if (array[left] <= array[right]) {
                tmp[k++] = array[p1++];
            }else {
                tmp[k++] = array[p2++];
            }
        }
        while (left < mid) {
            tmp[right++] = array[++left];
        }
        System.arraycopy(tmp, left, array, left, right + 1 - left);
    }

    public static void main(String[] args) {
        int array[] = new int[]{3, 5, 2, 1, 4, 6};
        mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
