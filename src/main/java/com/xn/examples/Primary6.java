package com.xn.examples;


import java.util.Arrays;

public class Primary6 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        // 暴力方法
        boolean[] visited1 = new boolean[nums1.length];
        boolean[] visited2 = new boolean[nums2.length];
        int index = 0;
        int length = 0;
        int[] array = new int[Math.max(nums1.length, nums2.length)];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] & !visited1[i] & !visited2[j]) {
                    array[index++] = nums1[i];
                    visited1[i] = true;
                    visited2[j] = true;
                    length++;
                }
            }
        }
        array = Arrays.copyOf(array, length);
        return array;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int index = 0;
        int length = 0;
        int[] array = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length & j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                array[index++] = nums1[i];
                i++;
                j++;
                length++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        array = Arrays.copyOf(array, length);
        return array;
    }

    public static void main(String[] args) {
        intersect2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }
}
