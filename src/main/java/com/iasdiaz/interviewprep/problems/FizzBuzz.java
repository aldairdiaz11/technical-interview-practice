package com.iasdiaz.interviewprep.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {

        if (n <= 0) return new ArrayList<>();

        return IntStream.range(1, n + 1).mapToObj(i -> {

            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0;

            if (fizz && buzz) {
                return "FizzBuzz";
            } else if (fizz) {
                return "Fizz";
            } else if (buzz) {
                return "Buzz";
            } else {
                return "" + i;
            }
        }).toList();
    }
}
