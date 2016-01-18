package Problem027;

/**
 * Euler discovered the remarkable quadratic formula:
 * <p>
 * n² + n + 41
 * <p>
 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
 * However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41,
 * and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 * <p>
 * The incredible formula  n² − 79n + 1601 was discovered,
 * which produces 80 primes for the consecutive values n = 0 to 79.
 * The product of the coefficients, −79 and 1601, is −126479.
 * <p>
 * Considering quadratics of the form:
 * <p>
 * n² + an + b, where |a| < 1000 and |b| < 1000
 * <p>
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |−4| = 4
 * <p>
 * Find the product of the coefficients, a and b,
 * for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 */

public class QuaPrimes {
    public static void main(String[] args) {
        int maxA = 0;
        int maxB = 0;
        int maxN = 0;

        for (int a = -999; a < 1001; a += 2)
            for (int b = 1; b < 1001; b++)
                if (getQuaPrimesCount(a, b) > maxN) {
                    maxA = a;
                    maxB = b;
                    maxN = getQuaPrimesCount(a, b);
                }

        System.out.println("Product: " + maxA * maxB);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }

    private static int getQuaPrimesCount(int a, int b) {
        int n = 0;
        while (isPrime(n * n + a * n + b)) n++;
        return n;
    }
}
