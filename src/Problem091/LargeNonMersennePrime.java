package Problem091;

import java.math.BigInteger;

/**
 * The first known prime found to exceed one million digits was discovered in 1999,
 * and is a Mersenne prime of the form 2^6972593−1; it contains exactly 2,098,960 digits.
 * Subsequently other Mersenne primes, of the form 2^p−1, have been found which contain more digits.
 * <p>
 * However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits:
 * 28433×2^7830457+1.
 * <p>
 * Find the last ten digits of this prime number.
 */

//just let the computer do its magic lol.
public class LargeNonMersennePrime {
    public static void main(String[] args) {
        BigInteger ans = new BigInteger("2");
        ans = new BigInteger("28433").multiply(ans.pow(7830457)).add(BigInteger.ONE);
        String str = ans.toString();
        System.out.println(str.substring(str.length() - 10, str.length()));
    }
}
