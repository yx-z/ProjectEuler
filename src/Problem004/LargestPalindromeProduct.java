package Problem004;


/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 **/

public class LargestPalindromeProduct {
    public static void main(String[] args) {
        //get max
        int max = 0;
        for (int i = 999; i >= 100; i--)
            for (int j = 999; j > 100; j--)
                if (isPalindrome(i * j) && i * j > max)
                    max = i * j;

        System.out.println(max);
    }

    private static boolean isPalindrome(long num) {
        long temp = num;
        long reverseNum = 0;
        //using divide by 10 to get each digit. An alternative is by converting to String and check each charAt
        while (num != 0) {
            reverseNum *= 10;
            reverseNum = reverseNum + num % 10;
            num /= 10;
        }
        return reverseNum == temp;
    }
}
