package Problem036;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */

public class DoubleBasePal {
    public static void main(String[] args) {

    }

    private static boolean isPal(String s) {
        int left = 0;
        int right = s.length() - 1;
        for (; left < right; left++, right--)
            if (s.charAt(left) != s.charAt(right)) return false;
        return true;
    }
}