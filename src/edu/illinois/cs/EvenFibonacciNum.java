package edu.illinois.cs;

/**
 * Problem 2:
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 **/

public class EvenFibonacciNum {
    public static void main(String[] args) {
        long sum = 0;
        long num1 = 1;
        long num2 = 2;
        do {
            if (num1 % 2 == 0) sum += num1;
            if (num2 % 2 == 0) sum += num2;
            num1 = num1 + num2;
            num2 = num1 + num2;
        } while (num1 <= 4000000 && num2 <= 4000000);

        System.out.println("Sum: " + sum);
    }
}
