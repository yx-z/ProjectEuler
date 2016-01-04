package edu.illinois.cs;

/**
 * Problem 3:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

public class LargestPrimeFactor {
    public static void main(String[] args) {
        long num = 600851475143L;
        for (long i = 3; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                num = num / i;
                i = 2;
            }
        }
    }
}
