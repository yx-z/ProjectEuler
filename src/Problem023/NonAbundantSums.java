package Problem023;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * <p>
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
 * the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class NonAbundantSums {
    private static HashSet<Integer> abundants = new HashSet<Integer>();

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 12; i <= 28123; i++)
            if (isAbundant(i)) abundants.add(i);

        for (int i = 1; i <= 28123; i++)
            if (!sumOfAbundants(i))
                sum += i;
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

    private static boolean isAbundant(int n) {
        return sum(divisors(n)) > n;
    }

    private static boolean sumOfAbundants(int n) {
        for (Integer i : abundants)
            if (abundants.contains(n - i)) return true;
        return false;
    }
}
