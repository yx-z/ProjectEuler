package Problem036;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */

public class DoublePal {
    public static void main(String[] args) {
        long sum = 0;
        for (long i = 0; i < 1000000; i++)
            if (isDoublePal(i)) sum += i;

        System.out.println("Sum: " + sum);
    }

    private static boolean isPal(String str) {
        for (int i = 0; i < str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        return true;
    }

    private static boolean isDoublePal(long num) {
        return isPal("" + num) && isPal(Long.toBinaryString(num));
    }


}
