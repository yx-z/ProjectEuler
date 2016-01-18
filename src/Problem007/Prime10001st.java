package Problem007;

import java.util.ArrayList;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 */

public class Prime10001st {
    //initialize with the first prime number: 2
    private static ArrayList<Long> primeNumList = new ArrayList<Long>() {{
        this.add(0, 2L);
    }};

    public static void main(String[] args) {
        //start from 3
        long num = 3;
        //main loop
        do {
            if (isPrime(num)) primeNumList.add(num);
            num += 2;
        } while (primeNumList.size() <= 10001);//get the prime number list with size 100001

        System.out.println("10001st Prime: " + primeNumList.get(10001 - 1));
    }

    //iff the number cannot be divided by any primes in the list -> it is a prime
    //2* is an exception as the first prime num
    private static boolean isPrime(long num) {
        if (num == 2) return true;
        for (long primeNum : primeNumList)
            if (num % primeNum == 0) return false;
        return true;
    }
}
