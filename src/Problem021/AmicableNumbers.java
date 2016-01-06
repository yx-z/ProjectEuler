package Problem021;

import java.util.ArrayList;

/**
 * Problem 21:
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * <p>
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class AmicableNumbers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 10000; i++)
            if (isAmicable(i)) sum += i;

        System.out.println("Sum: " + sum);
    }

    private static ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int end = n / 2;
        for (int i = 1; i <= end; i++)
            if (n % i == 0) ans.add(i);
        return ans;
    }

    private static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (Integer i : arr)
            sum += i;
        return sum;
    }

    private static boolean isAmicable(int n) {
        return n == sum(divisors(sum(divisors(n)))) && n != sum(divisors(n));
    }
}
