package org.example;

/**
 * Pow(x, n)
 *
 * @author xiaojie.huang
 * @date 2024-01-23
 */
public class Solution50 {
    public double myPow(double x, int n) {
        /*if (x == 1.0) {
            return x;
        }
        double result = 1.0;
        int num = Math.abs(n);
        for (int i = 0; i < num; i++) {
            result *= x;
        }
        if (n < 0) {
            result = 1 / result;
        }
        return result;*/
        return Math.pow(x, n);
    }

    public double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : quickMul(1 / x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
    }

}
