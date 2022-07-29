package com.xn.examples;

public class Primary8 {

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        while (count > 0) {
            int left = 0;
            for (int right = 1; right < nums.length; right++) {
                if (nums[left] == 0) {
                    int tmp = nums[left];
                    nums[left++] = nums[right];
                    nums[right] = tmp;
                } else {
                    left++;
                }
            }
            count--;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
