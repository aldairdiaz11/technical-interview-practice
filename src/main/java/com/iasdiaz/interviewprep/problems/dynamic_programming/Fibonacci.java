package com.iasdiaz.interviewprep.problems.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static int  fib(int n, Map<Integer, Integer> map) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        final int result = fib(n - 1, map) + fib(n - 2, map);
        map.put(n, result);
        return result;
    }

    public static int solve(int n) {

        final Map<Integer, Integer> map = new HashMap<>();

        if (n < 0) throw new IllegalArgumentException("n can't be negative");

        return fib(n, map);
    }

}
