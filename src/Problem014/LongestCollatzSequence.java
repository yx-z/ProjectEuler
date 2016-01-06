package Problem014;

/**
 Problem 14:

 The following iterative sequence is defined for the set of positive integers:

 n → n/2 (n is even)
 n → 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:
 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?

 NOTE: Once the chain starts the terms are allowed to go above one million.
*/
public class LongestCollatzSequence{
    public static void main(String[] args) {
        int start = 1;
        int max = 1;
        for (int i = 2; i < 1000000; i++) {
            int count = countCollatzSequenceLength(i);
            if (count > max) {
                start = i;
                max = count;
            }
        }

        System.out.println("Start @: " + start);
    }

    private static int countCollatzSequenceLength(long num) {
        if (num == 1) return 1;
        if (num % 2 == 0) {
            num = num / 2;
            return 1 + countCollatzSequenceLength(num);
        } else {
            num = 3 * num + 1;
            return 1 + countCollatzSequenceLength(num);
        }
    }
}