package Problem034;

import java.util.ArrayList;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * <p>
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * <p>
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

public class DigitFactorials {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 3; i <= 99999 ; i++)
            if(isCurious(i)) sum += i;
        System.out.println(sum);
    }

    private static ArrayList<Integer> toArr(int num) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (num != 0) {
            int digit = num % 10;
            ans.add(digit);
            num /= 10;
        }
        return ans;
    }

    private static long fact(int num) {
        if (num == 0) return 1;
        return num * fact(num - 1);
    }

    private static long factSumOfDigits(ArrayList<Integer> src) {
        long sum = 0;
        for(Integer i : src)
            sum += fact(i);
        return sum;
    }

    private static boolean isCurious (int num) {
        return factSumOfDigits(toArr(num)) == num;
    }
}
