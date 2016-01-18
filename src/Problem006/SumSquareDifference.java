package Problem006;

/**
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
        //square first, then add
        for (int i = 1; i <= 100; i++)
            sum += i * i;
        //1 + 2 + ... + 100 = 5050, i just know it lol.
        System.out.println(5050 * 5050 - sum);
    }
}
