package com.iasdiaz.interviewprep.problems.dynamic_programming;

public class Knapsack {

    private Knapsack() {
    }

    /**
     * Solves the 0/1 Knapsack problem using DP
     *
     * @param weights  array of item weights
     * @param values   array of item values
     * @param capacity maximum weight the knapsack can hold
     * @return maximum value achievable
     **/

    private static int knapsack(int[] weights, int[] values, int capacity, final int n) {

        int index, weight;
        final int[][] matrix = new int[n + 1][capacity + 1];

        for (index = 0; index <= n; index++) {
            for (weight = 0; weight <= capacity; weight++) {
                if (index == 0) {
                    matrix[index][weight] = 0;
                } else if (weights[index - 1] <= weight) {
                    matrix[index][weight] = Math.max(
                            values[index - 1] + matrix[index - 1][weight - weights[index - 1]],
                            matrix[index - 1][weight]
                    );
                } else {
                    matrix[index][weight] = matrix[index - 1][weight];
                }
            }
        }
        return matrix[n][capacity];
    }


    public static int solve(int[] weights, int[] values, int capacity) {

        if (weights == null || values == null) {
            throw new IllegalArgumentException("Weights and Values must be non-null");
        }

        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }

        final int n = values.length;

        if (n != weights.length) {
            throw new IllegalArgumentException("Weights and values sizes don't match");
        }

        if (n == 0) {
            return 0;
        }

        return Knapsack.knapsack(weights, values, capacity, values.length);
    }
}
