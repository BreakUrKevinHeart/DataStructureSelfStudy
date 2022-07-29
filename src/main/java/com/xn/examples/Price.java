package com.xn.examples;

public class Price {
    public static int maxProfit(int[] prices) {
        int count = 0;
        int left = 0;
        for (int right = 1; right < prices.length; right++) {
            if (prices[left] < prices[right]) {
                count += prices[right] - prices[left];
            }
            left++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
