package com.iasdiaz.interviewprep.algorithms.searching.concepts.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class FactorialTest {

    @Test
    public void factorialTest_shouldBeSameResult() {
        assertEquals(Factorial.iterativeFactorial(10),  Factorial.recursiveFactorial(10));
    }

    @Nested
    public class IterativeFactorial {
        @Test
        public void test_happyCase() {
            final int result = Factorial.iterativeFactorial(5);
            assertEquals(120, result);
        }

        @Test
        public void test_zero() {
            assertEquals(1, Factorial.iterativeFactorial(0));
        }
    }

    @Nested
    public class RecursiveFactorial {
        @Test
        public void test_happyCase() {
            final int result = Factorial.recursiveFactorial(5);
            assertEquals(120, result);
        }

        @Test
        public void test_zero() {
            assertEquals(1, Factorial.recursiveFactorial(0));
        }
    }
}