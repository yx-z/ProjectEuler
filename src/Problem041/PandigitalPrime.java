package Problem041;

import java.util.HashSet;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 */

public class PandigitalPrime {
    public static void main(String[] args) {
        int num = 7654321;
        while (!(isPrime(num) && isPandigital(num))) num--;
        System.out.println(num);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }

    private static boolean isPandigital(int num) {
        String toStr = "" + num;
        int length = toStr.length();
        HashSet<Integer> digits = new HashSet<>();
        //get each digit
        for (int i = 0; i < length; i++)
            digits.add(Integer.parseInt("" + toStr.charAt(i)));
        //no two numbers in a set can be the same. So if the set size != length, then the number must not be pandigital.
        if (digits.size() != length) return false;
        //check each number is contained in the set
        //in order to prevent cases like: 12346 -> 5 is missing but the size == length
        for (int i = 1; i <= length; i++)
            if (!digits.contains(i)) return false;
        return true;
    }
}