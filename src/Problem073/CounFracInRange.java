package Problem073;

import java.math.BigInteger;

/**
 * Consider the fraction, n/d, where n and d are positive integers.
 * If n<d and HCF(n,d)=1, it is called a reduced proper fraction.
 * <p>
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 * <p>
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * <p>
 * It can be seen that there are 3 fractions between 1/3 and 1/2.
 * <p>
 * How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
 */

public class CounFracInRange {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        final int LIMIT = 12000;
        int result = 0;

        for (int d = 5; d <= LIMIT; d++) {
            for (int n = d / a + 1; n < (d - 1) / b + 1; n++) {
                if (gcd(n, d) == 1) result++;
            }
        }

        System.out.println(result);
    }

    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}