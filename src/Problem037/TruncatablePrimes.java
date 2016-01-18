package Problem037;

import java.util.HashSet;

/**
 * The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 * <p>
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * <p>
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

public class TruncatablePrimes {
    public static void main(String[] args) {
        int counter = 0;
        int sum = 0;
        int num = 23;
        while (counter < 11) {
            if (isTrunatablePrime(toTrunArr(num))) {
                counter++;
                sum += num;
            }
            num += 2;
        }
        System.out.println(sum);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }

    private static HashSet<Integer> toTrunArr(int num) {
        HashSet<Integer> ans = new HashSet<>();
        String tmp = "" + num;
        while (num > 0) {
            ans.add(num);
            num /= 10;
        }
        for (int i = 1; i < tmp.length(); i++)
            ans.add(Integer.parseInt(tmp.substring(i, tmp.length())));
        return ans;
    }

    private static boolean isTrunatablePrime(HashSet<Integer> nums) {
        for (Integer i : nums)
            if (!isPrime(i)) return false;
        return true;
    }
}