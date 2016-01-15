package Problem003;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

public class LargestPrimeFactor {
    public static void main(String[] args) {
        //the num is obivously not divisible by 2
        long num = 600851475143L;
        for (long i = 3; i <= num; i++) {
            if (num % i == 0) {
                //print the last number only
                if (i == num) System.out.println(i);
                //if it is divisible by i, just divide it to get the num smaller
                num = num / i;
                //back to the start
                i = 3;
            }
        }
    }
}