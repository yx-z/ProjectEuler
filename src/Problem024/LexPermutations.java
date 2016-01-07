package Problem024;

import java.util.ArrayList;
import java.util.LinkedList;

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
        final int REMAINDER = 1000000;

        //find the indices
        ArrayList<Integer> index = new ArrayList<>();
        int currentIndex = 0;
        int sum = 0;
        for (int i = 9; i > 0; i--) {
            int j = 0;
            for (; j <= 9; j++) {
                if (sum + fact(i) * (j + 1) >= REMAINDER) {
                    sum += fact(i) * j;
                    break;
                }
            }
            index.add(currentIndex, j);
            currentIndex++;
        }

        //fill with nums
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            nums.add(i, i);
        long ans = 0;
        for (Integer i : index){
            ans += nums.get(i);
            nums.remove(nums.get(i));
            ans *= 10;
        }

        System.out.println(ans);
    }

    //util method for factorial
    private static int fact(int n) {
        if (n == 0) return 1;
        else return n * fact(n - 1);
    }
}