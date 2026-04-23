package com.iasdiaz.interviewprep.problems.sliding_window;

public class MaxSum {

    /**
     * Returns the maximum sum of any contiguous subarray of size k.
     *
     * @param arr input array (must not be null)
     * @param k size of the subarray (must be > 0 and <= arr.length)
     * @return maximum sum of subarray of size k
     * @throws IllegalArgumentException if input is invalid
     */
    public static int maxSum(final int[] arr, final int k) {


        if (arr == null) {
            throw new IllegalArgumentException("Input arr cannot be null");
        }

        final int n = arr.length;

        if (k <= 0 || k > n) {
            throw new IllegalArgumentException("Invalid window size k");
        }

        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        int maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum = currentSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
