package Problem005;

/**
 *  Problem 5:
 *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class SmallestMultiple {
    public static void main(String[] args) {
        int num = 2520;
        while(!allDivisable(num,2,20)){
            num++;
        }

        System.out.println(num);
    }

    private static boolean allDivisable(int num,int start,int end) {
        for (int i = start; i <= end; i++)
            if (num % i != 0) return false;

        return true;
    }
}
