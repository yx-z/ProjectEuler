package Problem049;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 * <p>
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property,
 * but there is one other 4-digit increasing sequence.
 * <p>
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */

public class PrimePerm {
    public static void main(String[] args) {
        //get all four digit primes
        ArrayList<Integer> primeNum = new ArrayList<>();
        for (int i = 1000; i < 10000; i++)
            if (isPrime(i)) primeNum.add(i);

        terminate:
        for (int i = 0; i < primeNum.size(); i++) {
            //skip the number in the question
            if (primeNum.get(i) == 1487) continue;
            for (int k = i + 1; k < primeNum.size(); k++) {
                //check the first two num
                if (hasSameDigits(primeNum.get(i), primeNum.get(k))) {
                    //get the third num by: adding (the difference of the first two num) to the second num
                    int num = primeNum.get(k) + primeNum.get(k) - primeNum.get(i);
                    if (isPrime(num) && hasSameDigits(num, primeNum.get(k))) {
                        //print the concatenated ans
                        System.out.println("" + primeNum.get(i) + primeNum.get(k) + num);
                        break terminate;
                    }
                }
            }
        }
    }

    //check if a num is prime
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= (int) Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    //check if two nums have same digits
    private static boolean hasSameDigits(int a, int b) {
        char[] arr = ("" + a).toCharArray();
        char[] brr = ("" + b).toCharArray();
        Arrays.sort(arr);
        Arrays.sort(brr);
        return Arrays.equals(arr,brr);
    }
}