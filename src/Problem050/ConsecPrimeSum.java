package Problem050;

import java.util.ArrayList;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * <p>
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * <p>
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 * <p>
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */

public class ConsecPrimeSum {
    //upper limit: 1 million
    private static final int MAX = 1000000;
    //get all primes under the max
    private static ArrayList<Integer> primes = new ArrayList<Integer>() {{
        this.add(2);
        for (int i = 3; i < MAX; i += 2)
            if (isPrime(i)) this.add(i);
    }};

    public static void main(String[] args) {
        int maxSum = 0;
        int maxLength = 0;

        //main loop for searching the sum starting from each prime
        for (int i = 0; i < primes.size(); i++) {
            int sum = 0;
            int length = 0;
            add:
            for (int j = i; j < primes.size(); j++) {
                //break if the sum will exceed the MAX
                if (sum + primes.get(j) <= MAX) {
                    sum += primes.get(j);
                    length++;
                } else
                    break add;
            }
            //compare the length
            if (length > maxLength && isPrime(sum)) {
                maxLength = length;
                maxSum = sum;
            }
        }

        System.out.println(maxSum);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}