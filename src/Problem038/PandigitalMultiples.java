package Problem038;

import java.util.Arrays;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <p>
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * <p>
 * By concatenating each product we get the 1 to 9 pandigital, 192384576.
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * <p>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
 * which is the concatenated product of 9 and (1,2,3,4,5).
 * <p>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of
 * an integer with (1,2, ... , n) where n > 1?
 */

public class PandigitalMultiples {
    public static void main(String[] args) {
        long result = 0;
        //upper bound can be smaller but doesn't affect much
        for (long i = 10000; i > 0; i--) {
            result = concat(i, 2 * i);
            if (isOneToNinePandigital(result)) break;
        }
        System.out.println(result);
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
