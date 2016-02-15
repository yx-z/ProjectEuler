package Problem062;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3).
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 * <p>
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */

public class CubicPerm {
	public static void main(String[] args) {
		//<String Permutation, Frequency>
		HashMap<String, Integer> frequenceCount = new HashMap<>();
		//345 given by problem
		int i = 345;
		//store permutation of the i cubed
		String digits;

		stop:
		while (true) {
			digits = getDigits(getCube(i));
			//update the frequency
			frequenceCount.put(digits,frequenceCount.getOrDefault(digits,0) + 1);

			for (Integer count : frequenceCount.values())
				if (count == 5) break stop;

			i++;
		}

		//since I only store the String permutation and the frequency, I need another loop to find the smallest number
		//that can construct this String permutation. need to be optimized
		int j;
		for (j = 345; j <= i;j++)
			if (getDigits(getCube(j)).equals(digits)) break;
		//get cubed number
		System.out.println(getCube(j));
	}

	//format the cube number
	private static String getDigits(BigInteger bi) {
		char[] digits = bi.toString().toCharArray();
		Arrays.sort(digits);
		return new String(digits);
	}

	private static BigInteger getCube(int i) {
		return new BigInteger("" + i).pow(3);
	}
}