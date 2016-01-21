package Problem053;

import java.math.BigInteger;

/**
 * There are exactly ten ways of selecting three from five, 12345:
 * <p>
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * <p>
 * In combinatorics, we use the notation, 5C3 = 10.
 * <p>
 * In general,
 * nCr = n!/r!(n−r)!
 * ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * <p>
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * <p>
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 */

public class CombinSelect {
    public static void main(String[] args) {
        int counter = 0;
        BigInteger MAX = BigInteger.TEN.pow(6);
        for (int n = 1; n <= 100; n++)
            for (int r = 0; r <= n; r++)
                if (com(n, r).compareTo(MAX) > 0)
                    counter++;

        System.out.println(counter);
    }

    private static BigInteger com(int n, int r) {
        BigInteger product = BigInteger.ONE;
        for (int i = 0; i < r; i++)
            product = product.multiply(BigInteger.valueOf(n - i));
        return product.divide(fact(r));
    }

    private static BigInteger fact(int n) {
        BigInteger prod = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            prod = prod.multiply(BigInteger.valueOf(i));
        return prod;
    }
}