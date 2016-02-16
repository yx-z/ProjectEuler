package Problem076;

/**
 * It is possible to write five as a sum in exactly six different ways:
 * <p>
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 * <p>
 * How many different ways can one hundred be written as a sum of at least two positive integers?
 */

//DP
public class CountingSums {
	public static void main(String[] args) {
		final int LIMIT = 100;
		int[] ways = new int[LIMIT + 1];
		ways[0] = 1;

		for (int i = 1; i < LIMIT; i++)
			for (int j = i; j <= LIMIT; j++)
				ways[j] += ways[j - i];

		System.out.println(ways[100]);
	}
}