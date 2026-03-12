package com.iasdiaz.interviewprep.problems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlusMinusTest {

    @Test
    void happyCase() {
        int[] arr = {-4, 3, -9, 0, 4, 1};
        final String result = PlusMinus.plusMinus(arr);

        assertEquals("""
                0.500000
                0.333333
                0.166667""", result);
    }

    @Test
    void emptyArray() {
        int[] arr = {};
        final String result = PlusMinus.plusMinus(arr);

        assertEquals("", result);
    }

    @Test
    void nullArray() {
        final String result = PlusMinus.plusMinus(null);
        assertEquals("", result);
    }

    @Test
    void allPositives() {
        int[] arr = {1, 2, 3, 4, 5};
        final String result = PlusMinus.plusMinus(arr);

        assertEquals("""
                1.000000
                0.000000
                0.000000""", result);
    }

    @Test
    void allNegatives() {
        int[] arr = {-1, -2, -3, -4};
        final String result = PlusMinus.plusMinus(arr);

        assertEquals("""
                0.000000
                1.000000
                0.000000""", result);
    }

    @Test
    void allZero() {
        int[] arr = {0, 0, 0, 0};
        final String result = PlusMinus.plusMinus(arr);

        assertEquals("""
                0.000000
                0.000000
                1.000000""", result);
    }

    @Test
    void equalDistribution() {
        int[] arr = {-1, 0, 1};
        final String result = PlusMinus.plusMinus(arr);

        assertEquals("""
                0.333333
                0.333333
                0.333333""", result);
    }

    @Test
    void singleElement() {
        int[] arr = {1};
        final String result = PlusMinus.plusMinus(arr);

        assertEquals("""
                1.000000
                0.000000
                0.000000""", result);
    }
}