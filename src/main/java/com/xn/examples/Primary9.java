package com.xn.examples;

import java.util.HashMap;
import java.util.Map;

public class Primary9 {

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = 1;
        int[] array = new int[2];
        while (left < nums.length && right < nums.length) {
            if (nums[left] + nums[right] == target) {
                array[0] = left;
                array[1] = right;
                break;
            }
            right++;
            if (left == right) {
                left--;
            }
        }
        return array;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i); // 数值->下标
        }
        return new int[2];
    }

    public static void main(String[] args) {
        twoSum(new int[]{3, 2, 3}, 6);
    }
}
