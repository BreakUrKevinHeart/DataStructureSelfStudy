package com.xn.examples;

import java.util.HashSet;
import java.util.Set;

public class Primary4 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num :
                nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

}
