package Problem057;

import java.math.BigInteger;

/**
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 * <p>
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 * <p>
 * By expanding this for the first four iterations, we get:
 * <p>
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 * <p>
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985,
 * is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.
 * <p>
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */

/*
analyse the numerator and denominator respectively:
n: 3 7 17 41 ... ->
d: 2 5 12 29 ... ->

n(i + 1) = n(i) + 2 * d(i)
d(i + 1) = n(i) + d(i) = n(i + 1) - d(i)
 */

public class SquareRootConvergent {
    public static void main(String[] args) {
        final int MAX = 1000;

        BigInteger n = new BigInteger("3");
        BigInteger d = new BigInteger("2");

        int count = 0;
        for (int i = 1; i <= MAX; i++) {
            n = n.add(d.multiply(new BigInteger("2")));
            d = n.subtract(d);
            if (numBigger(n,d)) count++;
        }

        System.out.println(count);
    }

    private static boolean numBigger(BigInteger n, BigInteger d) {
        return n.toString().length() > d.toString().length();
    }
}
