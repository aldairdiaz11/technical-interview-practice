package com.iasdiaz.interviewprep.problems.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaxSumTest {

    @ParameterizedTest(name = "{index} => nums={0}, k={1}, expected={2}")
    @MethodSource("validCases")
    @DisplayName("Should return correct max sum for valid inputs")
    void shouldReturnCorrectMaxSum(int[] nums, int k, int expected) {
        int result = MaxSum.maxSum(nums, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> validCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 5, 1, 3, 2}, 3, 9),
                Arguments.of(new int[]{2, 3, 4, 1, 5}, 2, 7),
                Arguments.of(new int[]{1, 2, 3, 4}, 1, 4),
                Arguments.of(new int[]{1, 2, 3, 4}, 4, 10),
                Arguments.of(new int[]{4, -1, 2, 1}, 2, 3),
                Arguments.of(new int[]{0, 0, 0, 0}, 2, 0)
        );
    }

    @Nested
    @DisplayName("Edge cases")
    class EdgeCases {

        @Test
        @DisplayName("Should handle all negative numbers")
        void shouldHandleAllNegativeNumbers() {
            int result = MaxSum.maxSum(new int[]{-5, -2, -3, -4}, 2);
            assertEquals(-5, result);
        }

        @Test
        @DisplayName("Should handle single element array")
        void shouldHandleSingleElement() {
            int result = MaxSum.maxSum(new int[]{5}, 1);
            assertEquals(5, result);
        }

        @Test
        @DisplayName("Should handle k equals array length")
        void shouldHandleKEqualsArrayLength() {
            int result = MaxSum.maxSum(new int[]{1, 2, 3}, 3);
            assertEquals(6, result);
        }
    }

    @Nested
    @DisplayName("Invalid inputs")
    class InvalidInputs {

        @Test
        void shouldThrowWhenArrayIsNull() {
            assertThrows(IllegalArgumentException.class,
                    () -> MaxSum.maxSum(null, 2));
        }

        @Test
        void shouldThrowWhenKIsZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> MaxSum.maxSum(new int[]{1, 2, 3}, 0));
        }

        @Test
        void shouldThrowWhenKIsNegative() {
            assertThrows(IllegalArgumentException.class,
                    () -> MaxSum.maxSum(new int[]{1, 2, 3}, -1));
        }

        @Test
        void shouldThrowWhenKGreaterThanArrayLength() {
            assertThrows(IllegalArgumentException.class,
                    () -> MaxSum.maxSum(new int[]{1, 2}, 3));
        }
    }
}
