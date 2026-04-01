package com.iasdiaz.interviewprep.problems.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SieveOfEratosthenesTest {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                // Edge cases
                org.junit.jupiter.params.provider.Arguments.of(0, List.of()),
                org.junit.jupiter.params.provider.Arguments.of(1, List.of()),

                // Small inputs
                org.junit.jupiter.params.provider.Arguments.of(2, List.of(2)),
                org.junit.jupiter.params.provider.Arguments.of(3, List.of(2, 3)),
                org.junit.jupiter.params.provider.Arguments.of(10, List.of(2, 3, 5, 7)),

                // Medium inputs
                org.junit.jupiter.params.provider.Arguments.of(20, List.of(2, 3, 5, 7, 11, 13, 17, 19)),
                org.junit.jupiter.params.provider.Arguments.of(30, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)),

                // Larger input sanity check
                org.junit.jupiter.params.provider.Arguments.of(50,
                        List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                                31, 37, 41, 43, 47))
        );
    }

    @ParameterizedTest(name = "n={0} -> primes={1}")
    @MethodSource("provideTestCases")
    @DisplayName("Should correctly compute primes up to n")
    void testSieve(int input, List<Integer> expected) {
        final List<Integer> result = SieveOfEratosthenes.sieve(input);
        assertEquals(expected, result);
    }
}
