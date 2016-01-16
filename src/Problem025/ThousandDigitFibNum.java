package Problem025;

import java.math.BigInteger;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p>
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * <p>
 * Hence the first 12 terms will be:
 * <p>
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * <p>
 * The 12th term, F12, is the first term to contain three digits.
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */

public class ThousandDigitFibNum {
    public static void main(String[] args) {
        int index = 2;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger tmp;

        //main Fibonacci looop
        while(countDigits(a) < 1000 && countDigits(b) < 1000) {
            tmp = a;
            a = b;
            b = b.add(tmp);
            index++;
        }

        System.out.println("Index: " + index);
    }

    //get the digit length of a BigInteger
    //ex. 12 -> 2, 123 -> 3
    private static int countDigits(BigInteger n) {
        return n.toString().length();
    }

}
