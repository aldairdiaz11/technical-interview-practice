package com.iasdiaz.interviewprep.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    void sort_shouldSortUnorderedArray() {
        int[] input = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleArrayWithDuplicates() {
        int[] input = {3, 6, 8, 3, 2, 3, 1};
        int[] expected = {1, 2, 3, 3, 3, 6, 8};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleNegativeNumbers() {
        int[] input = {0, -10, 5, -3, 8};
        int[] expected = {-10, -3, 0, 5, 8};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleSingleElementArray() {
        int[] input = {42};
        int[] expected = {42};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleEmptyArray() {
        int[] input = {};
        int[] expected = {};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleAllEqualElements() {
        int[] input = {7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7};

        QuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleNullArrayGracefully() {
        assertDoesNotThrow(() -> QuickSort.sort(null));
    }
}
