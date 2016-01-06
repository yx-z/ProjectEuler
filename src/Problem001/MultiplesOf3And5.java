package Problem001;

/**
 * Problem 1:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 **/

public class MultiplesOf3And5 {
    private static int sum = 0;

    public static void main(String[] args) {
	    for (int i = 0; i < 1000; i++) {
            if(multiplesOf3And5(i)) sum += i;
        }

        System.out.println("Sum: " + sum);
    }

    private static boolean multiplesOf3And5 (int num) {
        return (num % 3 == 0 || num % 5 == 0);
    }
}
