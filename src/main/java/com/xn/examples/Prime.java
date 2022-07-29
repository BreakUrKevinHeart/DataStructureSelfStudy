package com.xn.examples;

public class Prime {
    public static int bfPrime(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static int eratoPrime(int n) {
        boolean[] isPrime = new boolean[n]; // 默认值为false
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) { // false代表素数
                count++;
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // System.out.println(bfPrime(100));
        System.out.println(eratoPrime(100));
    }
}
