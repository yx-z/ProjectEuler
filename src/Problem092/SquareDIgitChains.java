package Problem092;

/**
 * A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.
 * <p>
 * For example,
 * <p>
 * 44 → 32 → 13 → 10 → 1 → 1
 * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
 * <p>
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop.
 * What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
 * <p>
 * How many starting numbers below ten million will arrive at 89?
 */

//pretty straightforward, by brute force
public class SquareDIgitChains {
    public static void main(String[] args) {
        final int UPPER_BOUND = 10000000;
        int count = 0;
        for (int i = 1; i < UPPER_BOUND; i++)
            if (arrive89(i)) count++;

        System.out.println(count);
    }

    //not using recursion which might cause stack overflow error.
    private static boolean arrive89(int n) {
        while (n != 89 && n != 1) n = getNextNum(n);
        return n == 89;
    }

    private static int getNextNum(int n) {
        String toStr = "" + n;
        int sum = 0;
        for (int i = 0; i < toStr.length(); i++)
            sum += Math.pow(Integer.parseInt("" + toStr.charAt(i)), 2);
        return sum;
    }
}