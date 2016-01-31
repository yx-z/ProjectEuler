package Problem047;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The first two consecutive numbers to have two distinct prime factors are:
 * <p>
 * 14 = 2 × 7
 * 15 = 3 × 5
 * <p>
 * The first three consecutive numbers to have three distinct prime factors are:
 * <p>
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * <p>
 * Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 */

public class DistinctPrimesFact {
    public static void main(String[] args) {
        int n = 2 * 3 * 5 * 7;
        while (!fourConsecutive(n)) n++;
        System.out.println(n);
    }

    private static boolean fourConsecutive(int n) {
        return countPrimeFactors(n) == 4 && countPrimeFactors(n + 1) == 4 && countPrimeFactors(n + 2) == 4 && countPrimeFactors(n + 3) == 4;
    }

    private static int countPrimeFactors(int n) {
        int count = 0;
        for (int i = 2, end = (int) Math.sqrt(n); i <= end; i++) {
            if (n % i == 0) {
                //decrease the range
                do n /= i;
                while (n % i == 0);
                count++;
                //update ending condition
                end = (int) Math.sqrt(n);
            }
        }
        //if remainder is a prime, add 1
        if (n > 1) count++;
        return count;
    }
}
