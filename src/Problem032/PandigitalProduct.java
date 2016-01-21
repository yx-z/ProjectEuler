package Problem032;

import java.util.Arrays;
import java.util.HashSet;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * <p>
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254,
 * containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * <p>
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */

public class PandigitalProduct {
    public static void main(String[] args) {
        int sum = 0;
        //store respective numbers
        HashSet<Long> ans = new HashSet<>();
        //main loop
        for (int i = 2; i < 10000; i++)
            //set bounds for j: when i has 1 digit, then j must has 4 digits ex: 1 * 1234 = 1234 -> 112341234 has 9 digits
            for (int j = 10000 / i; j > i; j--) {
                long product = i * j;
                if (isOneToNinePandigital(concat(i, concat(j, product)))) ans.add(product);
            }
        for(Long l : ans)
            sum += l;
        System.out.println(sum);
    }

    //check whether the number matches the condition in the question
    private static boolean isOneToNinePandigital(long num) {
        String toStr = "" + num;
        if (toStr.length() != 9) return false;
        char[] digits = toStr.toCharArray();
        Arrays.sort(digits);
        return String.valueOf(digits).equals("123456789");
    }

    private static long concat(long a, long b) {
        return Long.parseLong(a + "" + b);
    }
}
