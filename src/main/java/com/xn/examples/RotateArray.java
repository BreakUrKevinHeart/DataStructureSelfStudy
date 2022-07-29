package com.xn.examples;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] tmp = new int[length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % length] = tmp[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
