package Problem069;

import java.util.ArrayList;

/**
 * Euler's Totient function, φ(n) [sometimes called the phi function],
 * is used to determine the number of numbers less than n which are relatively prime to n.
 * For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 * <p>
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 */

/*
According to Wiki: we need to minimize: prod_{p\mid n} \frac{1}{1-p) while n is smaller than the MAX = 1,000,000;
*/

public class TotientMax {
    public static void main(String[] args) {
        final int MAX = 1000000;

        int result = 1;
        int i = 0;

        //get primes
        ArrayList<Integer> primes = new ArrayList<>();
        for (int j = 2; j < 1000000; j++)
            if (isPrime(j)) primes.add(j);

        while (result * primes.get(i) < MAX) {
            result *= primes.get(i);
            i++;
        }

        System.out.println(result);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}