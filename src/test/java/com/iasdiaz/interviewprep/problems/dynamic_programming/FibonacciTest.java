package com.iasdiaz.interviewprep.problems.dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void testBaseCases() {
        assertEquals(0, Fibonacci.solve(0));
        assertEquals(1, Fibonacci.solve(1));
    }

    @Test
    void testSmallNumbers() {
        assertEquals(1, Fibonacci.solve(2));
        assertEquals(2, Fibonacci.solve(3));
        assertEquals(3, Fibonacci.solve(4));
        assertEquals(5, Fibonacci.solve(5));
        assertEquals(8, Fibonacci.solve(6));
    }

    @Test
    void testMediumNumbers() {
        assertEquals(55, Fibonacci.solve(10));
        assertEquals(610, Fibonacci.solve(15));
        assertEquals(6765, Fibonacci.solve(20));
    }

    @Test
    void testLargerNumber() {
        assertEquals(832040, Fibonacci.solve(30));
    }

    @Test
    void testNegativeInput() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> Fibonacci.solve(-1));

        assertEquals("n can't be negative", exception.getMessage());
    }

    @Test
    void testRepeatedCalls() {
        // Ensures no shared state bugs if you fix the static map
        assertEquals(55, Fibonacci.solve(10));
        assertEquals(55, Fibonacci.solve(10));
        assertEquals(144, Fibonacci.solve(12));
    }
}
