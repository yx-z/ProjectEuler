package Problem016;

import java.math.BigInteger;

/**
 * Problem 16:
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */

public class PowerDigitSum {
    public static void main(String[] args) {
        String str = "" + new BigInteger("2").pow(1000);
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
            sum += Integer.parseInt(str.substring(i,i+1));

        System.out.println("Sum: " + sum);
    }
}
