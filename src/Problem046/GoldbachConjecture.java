package Problem046;

/**
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 * <p>
 * 9 = 7 + 2×12
 * 15 = 7 + 2×22
 * 21 = 3 + 2×32
 * 25 = 7 + 2×32
 * 27 = 19 + 2×22
 * 33 = 31 + 2×12
 * <p>
 * It turns out that the conjecture was false.
 * <p>
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */

public class GoldbachConjecture {
    public static void main(String[] args) {
        for (int i = 9; ; i += 2)
            if (!inConjecture(i)) {
                System.out.println(i);
                break;
            }
    }

    private static boolean inConjecture(int n) {
        if (n % 2 == 0 || isPrime(n)) return true;

        //odd composite n
        for (int i = 1; i * i * 2 <= n; i++)
            if (isPrime(n - i * i * 2)) return true;
        return false;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}
