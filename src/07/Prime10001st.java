package edu.illinois.cs;

import java.util.ArrayList;

/**
 * Problem 7:
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 */

public class Prime10001st {
    private static ArrayList<Long> primeNumList = new ArrayList<>();

    public static void main(String[] args) {
        primeNumList.add(2L);
        long num = 3;
        do {
            if (isPrime(num)) primeNumList.add(num);
            num += 2;
        } while (primeNumList.size() <= 10001);

        System.out.println("10001st Prime: " + primeNumList.get(10001 - 1));
    }

    private static boolean isPrime(long num) {
        for (long primeNum : primeNumList)
            if (num % primeNum == 0) return false;

        return true;
    }
}
