package Problem056;

import java.math.BigInteger;

/**
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 1
 * 00100 is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 * <p>
 * Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 */

public class PowDigitSum {
    public static void main(String[] args) {
        //brute force
        int max = 0;
        for (int a = 0; a < 100; a++)
            for (int b = 0; b < 100; b++)
                if (sumOfDigits("" + new BigInteger("" + a).pow(b)) > max)
                    max = sumOfDigits("" + new BigInteger("" + a).pow(b));

        System.out.println("Max: " + max);
    }

    private static int sumOfDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
            sum += Integer.parseInt("" + str.charAt(i));
        return sum;
    }
}
