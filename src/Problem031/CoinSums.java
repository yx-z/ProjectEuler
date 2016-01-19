package Problem031;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * <p>
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * <p>
 * How many different ways can £2 be made using any number of coins?
 */

public class CoinSums {
    //solve with dynamic programming
    public static void main(String[] args) {
        final int TARGET = 200;
        int[] coins = new int[]{ 1, 2, 5, 10, 20, 50, 100, 200 };
        int[] ways = new int[TARGET+1];
        //base case
        ways[0] = 1;

        //main loop for DP
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= TARGET; j++)
                //based on what we have already figured out, add the remaining part with new coins
                ways[j] += ways[j - coins[i]];

        //print out the last one in the ans arr;
        System.out.println(ways[TARGET - 1]);
    }
}