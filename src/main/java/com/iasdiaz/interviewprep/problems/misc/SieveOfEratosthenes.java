package com.iasdiaz.interviewprep.problems.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {

    private SieveOfEratosthenes() {}

    public static List<Integer> sieve(final int n) {

        if (n < 2) {
            return List.of();
        }

        boolean[] isPrime = computeSieve(n);
        final List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean[] computeSieve(final int end) {
        final boolean[] isPrime = new boolean[end + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int element = 2; element * element <= end; element++) {
            if (isPrime[element]) {  // if true, element is still considered prime
                for (int j = element * element; j <= end; j += element) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
