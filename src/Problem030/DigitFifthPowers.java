package Problem030;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <p>
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * <p>
 * As 1 = 1^4 is not a sum it is not included.
 * <p>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <p>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */

public class DigitFifthPowers {
    public static void main(String[] args) {
        //sum up all verifed numbers
        int sum = 0;
        for (int i = 2; i < 1000000; i++)
            if (canBeDigitFifthPowers(i)) sum += i;
        System.out.println(sum);
    }

    //check the condition in the question
    private static boolean canBeDigitFifthPowers(int x) {
        int sum = 0;
        int tmp = x;
        while (x != 0) {
            int y = x % 10;
            sum += y * y * y * y * y;
            x /= 10;
        }
        return sum == tmp;
    }
}
