package edu.illinois.cs;

/**
 * Problem 12:
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <p>
 * Let us list the factors of the first seven triangle numbers:
 * 1 : 1
 * 3 : 1,3
 * 6 : 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * <p>
 * We can see that 28 is the first triangle number to have over five divisors.
 * What is the value of the first triangle number to have over five hundred divisors?
 */

public class HighlyDivisibleTriNum {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 1; ; i++) {
            num += i;
            if (divisors(num) > 500) break;
        }
        System.out.println("Num: " + num);
    }

    private static int divisors(int n) {
        int count = 0;
        int end = (int) Math.sqrt(n);
        for (int i = 1; i < end; i++)
            if (n % i == 0) count += 2;
        if (end * end == n) count++;
        return count;
    }
}
