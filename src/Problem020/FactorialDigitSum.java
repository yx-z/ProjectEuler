package Problem020;

import java.math.BigInteger;

/**
 * Problem 20:
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */

public class FactorialDigitSum {
    public static void main(String[] args) {
        BigInteger factorial = fact(100);
        System.out.println("Sum: " + sumOfDigits(factorial));
    }

    private static BigInteger fact(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    private static int sumOfDigits(BigInteger n) {
        String factorialStr = n.toString();
        int ans = 0;
        for (int pos = 0; pos < factorialStr.length(); pos++)
            ans += Character.getNumericValue(factorialStr.charAt(pos));
        return ans;
    }
}
