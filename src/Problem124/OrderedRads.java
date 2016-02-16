package Problem124;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * The radical of n, rad(n), is the product of the distinct prime factors of n. For example, 504 = 23 × 32 × 7, so rad(504) = 2 × 3 × 7 = 42.
 * <p>
 * If we calculate rad(n) for 1 ≤ n ≤ 10, then sort them on rad(n), and sorting on n if the radical values are equal, we get:
 * (omitted)
 * Let E(k) be the kth element in the sorted n column; for example, E(4) = 8 and E(6) = 9.
 * <p>
 * If rad(n) is sorted for 1 ≤ n ≤ 100000, find E(10000).
 */

public class OrderedRads {

	public static void main(String[] args) {
		final int LIMIT = 100000;
		final int TARGET = 10000;

		ArrayList<RadPair> rad = new ArrayList<>();

		for (int i = 1; i <= LIMIT; i++)
			rad.add(new RadPair(i));
		Collections.sort(rad);

		System.out.println(rad.get(TARGET - 1).getNum());
	}

	static int getRad(int num) {
		HashSet<Integer> radElements = new HashSet<>();
		for (int i = 2; i <= num; i++) {
			if (isPrime(i) && num % i == 0) {
				radElements.add(i);
				num = num / i;
				i = 2;
			}
		}

		int prod = 1;
		for (Integer i : radElements)
			prod *= i;

		return prod;
	}

	private static boolean isPrime(int num) {
		if (num <= 1) return false;
		if (num == 2) return true;
		for (int i = 2; i <= (int) (Math.sqrt(num)); i++)
			if (num % i == 0) return false;
		return true;
	}
}

class RadPair implements Comparable<RadPair> {
	private int num;
	private int radNum;

	public RadPair(int num) {
		this.num = num;
		this.radNum = OrderedRads.getRad(num);
	}

	public int getNum() {
		return num;
	}

	@Override
	public int compareTo(RadPair o) {
		return this.radNum - o.radNum;
	}
}