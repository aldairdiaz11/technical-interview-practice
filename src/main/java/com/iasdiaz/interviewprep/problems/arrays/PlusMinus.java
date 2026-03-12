package com.iasdiaz.interviewprep.problems.arrays;

public class PlusMinus {

    public static String plusMinus(final int[] arr) {

        if (arr == null || arr.length == 0) return "";

        final int n = arr.length;

        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int num : arr) {
            if (num > 0) positive++;
            else if (num < 0) negative++;
            else zero++;
        }

        final double positiveRatio = (double) positive / n;
        final double negativeRatio = (double) negative / n;
        final double zeroRatio = (double) zero / n;

        return String.format("%.6f%n%.6f%n%.6f", positiveRatio, negativeRatio, zeroRatio);
    }
}
