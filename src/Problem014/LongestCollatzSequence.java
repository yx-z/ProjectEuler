package Problem014;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * <p>
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class LongestCollatzSequence {
    public static void main(String[] args) {
        int start = 1;
        int max = 1;
        //get max
        for (int i = 2; i < 1000000; i++) {
            int count = countCollatzSequenceLength(i);
            if (count > max) {
                start = i;
                max = count;
            }
        }
        System.out.println("Start @: " + start);
    }

    //get length using recursion
    private static int countCollatzSequenceLength(long num) {
        //base case
        if (num == 1) return 1;
        //conditional case with different operations for the number
        if (num % 2 == 0) {
            num = num / 2;
            return 1 + countCollatzSequenceLength(num);
        } else {
            num = 3 * num + 1;
            return 1 + countCollatzSequenceLength(num);
        }
    }
}