package com.iasdiaz.interviewprep.problems.dynamic_programming;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KnapsackTest {

    @Test
    void testMismatchedArrays() {
        int[] weights = {1, 2};
        int[] values = {10};

        assertThrows(IllegalArgumentException.class, () ->
                Knapsack.solve(weights, values, 5)
        );
    }

    static Stream<Arguments> knapsackCases() {
        return Stream.of(
                // Basic
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{10, 15, 40},
                        6,
                        65
                ),

                // Not greedy
                Arguments.of(
                        new int[]{1, 3, 4, 5},
                        new int[]{1, 4, 5, 7},
                        7,
                        9
                ),

                // Single item
                Arguments.of(
                        new int[]{5},
                        new int[]{10},
                        5,
                        10
                ),

                // Empty input
                Arguments.of(
                        new int[]{},
                        new int[]{},
                        10,
                        0
                ),

                // Zero capacity
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{10, 20, 30},
                        0,
                        0
                ),

                // Zero capacity, zero weights
                Arguments.of(
                        new int[]{0, 2, 3},
                        new int[]{10, 20, 30},
                        0,
                        10
                ),

                // All items too heavy
                Arguments.of(
                        new int[]{5, 6, 7},
                        new int[]{10, 20, 30},
                        3,
                        0
                ),

                // Zero value items
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{0, 0, 10},
                        3,
                        10
                ),

                // Zero weight item
                Arguments.of(
                        new int[]{0, 2, 3},
                        new int[]{10, 20, 30},
                        5,
                        60
                ),

                // Greedy fails
                Arguments.of(
                        new int[]{10, 20, 30},
                        new int[]{60, 100, 120},
                        50,
                        220
                ),

                // Multiple optimal solutions
                Arguments.of(
                        new int[]{2, 2, 2},
                        new int[]{10, 10, 10},
                        4,
                        20
                ),

                // Large capacity
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        new int[]{10, 20, 30, 40},
                        10,
                        100
                ),

                // Heavy high-value item ignored
                Arguments.of(
                        new int[]{1, 2, 10},
                        new int[]{10, 20, 100},
                        3,
                        30
                ),

                // Larger input
                Arguments.of(
                        new int[]{1, 3, 4, 5, 9, 4},
                        new int[]{10, 40, 50, 70, 80, 30},
                        10,
                        130
                ),

                // Many small items
                Arguments.of(
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                        5,
                        30
                )
        );
    }

    @ParameterizedTest
    @MethodSource("knapsackCases")
    void testKnapsack(int[] weights, int[] values, int capacity, int expected) {
        assertEquals(expected, Knapsack.solve(weights, values, capacity));
    }
}
