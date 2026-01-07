package com.iasdiaz.interviewprep.algorithms.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
    public void testSearch() {
        Integer[] searchable = {1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        int target = 41;

        int result = BinarySearch.search(searchable, target);
        assertEquals(6, result);
    }

    @Test
    public void testSearchNotFound() {
        Integer[] searchable = {1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        int target = 95;

        int result = BinarySearch.search(searchable, target);
        assertEquals(-1, result);
    }

    @Test
    public void testSearchEmpty() {
        Integer[] searchable = {};
        int target = 95;
        int result = BinarySearch.search(searchable, target);
        assertEquals(-1, result);
    }

    @Test
    public void testSearchNullArr() {
        int target = 95;
        int result = BinarySearch.search(null, target);
        assertEquals(-1, result);
    }

    @Test
    public void testSearchFirstElement() {
        Integer[] searchable = {1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        int target = 1;

        int result = BinarySearch.search(searchable, target);
        assertEquals(0, result);
    }

    @Test
    public void testSearchLastElement() {
        Integer[] searchable = {1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        int target = 94;

        int result = BinarySearch.search(searchable, target);
        assertEquals(searchable.length - 1, result);
    }

    @Test
    public void testSearchSingleElement() {
        Integer[] searchable = {1};
        int target = 1;

        int result = BinarySearch.search(searchable, target);
        assertEquals(0, result);
    }
}
