package Problem024;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * <p>
 * 012   021   102   120   201   210
 * <p>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

/*
First we want to figure out, which number is first in the millionth lexicographical permutation.
The last nine digits can be ordered in 9! = 362880 ways. So the first 362880 permutations start with a 0.
The permutations from 362881 to 2 * 9! = 725760 start with a 1.
And then the permutations from 725761 to 3 * 9! = 1088640 starts with a 2.
Based on that it is clear that the millionth permutation is in the third interval, and thus must start with a 2.

If we now assume the second num is 1, leaving 8! = 40320 alternatives.
(10000 - 725760) / 40320 = 7...
So the second num is 7

And so forth
*/

public class LexPermutations {
    public static void main(String[] args) {
        int remainder = 1000000 - 1;
        int factorial = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
        int[] factoid = new int[10];

        for (int i = 9; i >= 1; i--) {
            factoid[i] = remainder / factorial;
            remainder %= factorial;
            factorial /= i;
        }

        for (int i = 1; i <= 9; i++)
            for (int j = i - 1; j >= 0; j--)
                if (factoid[j] >= factoid[i]) factoid[j]++;

        for (int i = 9; i >= 0; i--)
            System.out.print(factoid[i]);
    }
}