package Problem006;

/**
 * Problem 6:
 * The sum of the squares of the first ten natural numbers is:
 * 1^2 + 2^2 + ... + 10^2 = 385
 * <p>
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * <p>
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class SumSquareDifference {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }

        System.out.println(5050 * 5050 - sum);
    }
}
