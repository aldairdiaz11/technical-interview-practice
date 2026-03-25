package com.iasdiaz.interviewprep.problems.two_pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RainWaterTest {

    static Stream<Object[]> data() {
        return Stream.of(new Object[][] {
                { new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6 },
                { new int[]{4,2,0,3,2,5}, 9 },
                { new int[]{1,2,3,4,5}, 0 },
                { new int[]{5,4,3,2,1}, 0 },
                { new int[]{2,0,2}, 2 },
                { new int[]{3,0,2,0,4}, 7 },
                { new int[]{1,0,1}, 1 },
                { new int[]{5,0,0,0,5}, 15 }
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    void testSolve(int[] input, int expected) {
        assertEquals(expected, RainWater.solve(input));
    }
}
