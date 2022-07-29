package com.xn.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Primary5 {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num :
                nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return (int) set.toArray()[0];
    }

    public static int singleNumber3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1111;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber3(new int[]{4, 1, 2, 1, 2, 1})); // 1,1,2,2,4
    }
}
