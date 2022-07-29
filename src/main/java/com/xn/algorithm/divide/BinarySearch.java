package com.xn.algorithm.divide;

public class BinarySearch {

    /**
     * 根据传入的数组查询指定数字在哪个位置
     * @param nums
     * @param n
     * @return
     */
    public static int search(int nums[], int n){
        int l = 0;
        int r = nums.length - 1;
        int mid = (l + r) / 2;

        while(l <= r) {
            if (nums[mid] > n){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5};
        System.out.println(search(a, 3)); // 2
    }
}
