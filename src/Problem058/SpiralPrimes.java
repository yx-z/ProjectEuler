package Problem058;

/**
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
 * <p>
 * 37 36 35 34 33 32 31
 * 38 17 16 15 14 13 30
 * 39 18  5  4  3 12 29
 * 40 19  6  1  2 11 28
 * 41 20  7  8  9 10 27
 * 42 21 22 23 24 25 26
 * 43 44 45 46 47 48 49
 * <p>
 * It is interesting to note that the odd squares lie along the bottom right diagonal,
 * but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 * <p>
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed.
 * If this process is continued,
 * what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
 */

/*
bottom right: n^2
bottom left: n^2 - (n - 1)
top left: n^2 - 2(n - 1)
top right: n^2 - 3(n - 1)
 */

public class SpiralPrimes {
    public static void main(String[] args) {
        int dim = 3;
        int primes = 0;
        while (true) {
            if (isPrime(dim * dim - (dim - 1))) primes++;
            if (isPrime(dim * dim - 2 * (dim - 1))) primes++;
            if (isPrime(dim * dim - 3 * (dim - 1))) primes++;

            if ((double) primes / (double) (dim * 2 - 1) <= .1) break;
            dim += 2;
        }

        System.out.println(dim);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}