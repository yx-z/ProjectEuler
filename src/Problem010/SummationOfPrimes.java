package Problem010;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */

public class SummationOfPrimes {
    public static void main(String[] args) {
        long sum = 0;
        for (long i = 2; i < 2000000; i++)
            if (isPrime(i)) sum += i;
        System.out.println("Sum: " + sum);
    }

    private static boolean isPrime(long num) {
        if (num == 2) return true;
        for (int i = 2; i <= (int) (Math.sqrt(num)); i++)
            if (num % i == 0) return false;
        return true;
    }
}
