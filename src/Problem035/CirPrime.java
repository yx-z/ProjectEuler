package Problem035;

import java.util.ArrayList;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * <p>
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * <p>
 * How many circular primes are there below one million?
 */

public class CirPrime {
    public static void main(String[] args) {
        final int MAX = 1000000;
        int counter = 0;
        for (int i = 2; i < MAX; i++) {
            if(isCirPrime(getCir(i))) counter++;
        }
        System.out.println(counter);
    }

    private static ArrayList<Integer> getCir(int num) {
        ArrayList<Integer> ans = new ArrayList<>();
        int length = ("" + num).length();
        int tmpLength = length;
        while (length > 0) {
            ans.add(num);
            int lastDigit = num % 10;
            num = (int) Math.pow(10, tmpLength - 1) * lastDigit + num / 10;
            length--;
        }
        return ans;
    }

    private static boolean isCirPrime(ArrayList<Integer> src) {
        for (Integer i : src)
            if (!isPrime(i)) return false;
        return true;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }


}
