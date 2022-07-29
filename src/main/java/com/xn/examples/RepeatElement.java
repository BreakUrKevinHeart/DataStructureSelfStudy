package com.xn.examples;

public class RepeatElement {
    public static int deleteRepetition(int nums[]) {
        assert nums == null : "nums is null";
        int left = 0;
        int count = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(deleteRepetition(nums));
    }
}
