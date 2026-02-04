package com.iasdiaz.interviewprep.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    @Test
    void shouldReturnEmptyListWhenNIsZero() {
        List<String> result = FizzBuzz.fizzBuzz(0);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenNIsNegative() {
        List<String> result = FizzBuzz.fizzBuzz(-5);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnCorrectListSize() {
        List<String> result = FizzBuzz.fizzBuzz(15);
        assertEquals(15, result.size());
    }

    @Test
    void shouldReplaceMultiplesOfThreeWithFizz() {
        List<String> result = FizzBuzz.fizzBuzz(3);
        assertEquals("Fizz", result.get(2)); // index 2 → number 3
    }

    @Test
    void shouldReplaceMultiplesOfFiveWithBuzz() {
        List<String> result = FizzBuzz.fizzBuzz(5);
        assertEquals("Buzz", result.get(4)); // index 4 → number 5
    }

    @Test
    void shouldReplaceMultiplesOfThreeAndFiveWithFizzBuzz() {
        List<String> result = FizzBuzz.fizzBuzz(15);
        assertEquals("FizzBuzz", result.get(14)); // index 14 → number 15
    }

    @Test
    void shouldReturnNumberAsStringWhenNotFizzOrBuzz() {
        List<String> result = FizzBuzz.fizzBuzz(2);
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
    }

    @Test
    void shouldGenerateCorrectFullSequenceUpToFive() {
        List<String> result = FizzBuzz.fizzBuzz(5);

        List<String> expected = List.of(
                "1",
                "2",
                "Fizz",
                "4",
                "Buzz"
        );

        assertEquals(expected, result);
    }
}
