package Problem063;

import java.math.BigInteger;

/**
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
 * <p>
 * How many n-digit positive integers exist which are also an nth power?
 */

/*
Let's consider the pow k^n.

For k: If k = 10, k^n has exactly (n + 1) digits. ex. 10^1 = 10, 10^2 = 100, etc. So exclude k = 10.
If k > 10, k^n > 10^n which has at least (n + 1) digits. As a result, k > 10 are excluded.
So we have 1 <= k <= 9 (one digit positive integers).

For n: If n = 22, take the biggest possible num to be formed: 9^22 ≈ 9.8 * 10^20 which is 21 digit long < 22
If n > 22, same thing happens: num is just too small to be n-digit length
So we have 1 <= n <= 21.
 */

public class PowDigitCounts {
    public static void main(String[] args) {
        int count = 0;
        for (int k = 1; k <= 9; k++)
            for (int n = 1; n <= 21; n++)
                if (samePowDigit(k,n)) count++;
        System.out.println(count);
    }

    private static boolean samePowDigit(int base, int pow) {
        return new BigInteger("" + base).pow(pow).toString().length() == pow;
    }
}