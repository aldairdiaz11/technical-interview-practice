package com.iasdiaz.interviewprep.algorithms.recursion;

public class Factorial {
    public static int iterativeFactorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n -= 1;
        }
        return result;
    }

    public static int recursiveFactorial(int n) {
        if (n > 0) return n * recursiveFactorial(n - 1);
        else return 1;
    }
}
