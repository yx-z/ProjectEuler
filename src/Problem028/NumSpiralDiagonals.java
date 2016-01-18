package Problem028;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */

public class NumSpiralDiagonals {
    public static void main(String[] args) {
        final int SIZE = 1001;
        long sum = 1;  //size 1
        for (int n = 3; n <= SIZE; n += 2)
            //each circular of nums
            sum += 4 * n * n - 6 * (n - 1);
        System.out.println(sum);
    }
}
