package com.iasdiaz.interviewprep.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    void sort_shouldSortUnorderedArray() {
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleArrayWithDuplicates() {
        int[] input = {4, 2, 4, 1, 2};
        int[] expected = {1, 2, 2, 4, 4};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleNegativeNumbers() {
        int[] input = {0, -3, 5, -1, 2};
        int[] expected = {-3, -1, 0, 2, 5};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleSingleElementArray() {
        int[] input = {42};
        int[] expected = {42};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleEmptyArray() {
        int[] input = {};
        int[] expected = {};

        MergeSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleNullArrayGracefully() {
        assertDoesNotThrow(() -> MergeSort.sort(null));
    }
}
