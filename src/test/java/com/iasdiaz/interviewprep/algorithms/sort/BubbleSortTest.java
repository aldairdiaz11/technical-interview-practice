package com.iasdiaz.interviewprep.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    void sort_shouldSortUnorderedArray() {
        int[] input = {5, 1, 4, 2, 8};
        int[] expected = {1, 2, 4, 5, 8};

        BubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        BubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        BubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleArrayWithDuplicates() {
        int[] input = {3, 1, 2, 3, 1};
        int[] expected = {1, 1, 2, 3, 3};

        BubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleSingleElementArray() {
        int[] input = {42};
        int[] expected = {42};

        BubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleEmptyArray() {
        int[] input = {};
        int[] expected = {};

        BubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sort_shouldHandleNegativeNumbers() {
        int[] input = {0, -5, 3, -1, 2};
        int[] expected = {-5, -1, 0, 2, 3};

        BubbleSort.sort(input);

        assertArrayEquals(expected, input);
    }
}
