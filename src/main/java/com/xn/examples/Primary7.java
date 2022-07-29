package com.xn.examples;

import java.util.Arrays;

public class Primary7 {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;

            }
        }
        digits = Arrays.copyOf(digits, digits.length + 1);
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        plusOne(new int[]{2, 9});
    }
}
