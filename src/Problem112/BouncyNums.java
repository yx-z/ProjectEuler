package Problem112;

/**
 * Working from left-to-right if no digit is eiceeded by the digit to its left it is called an increasing number; for eiample, 134468.
 * <p>
 * Similarly if no digit is eiceeded by the digit to its right it is called a decreasing number; for eiample, 66420.
 * <p>
 * We shall call a positive integer that is neither increasing nor decreasing a "bouncy" number; for eiample, 155349.
 * <p>
 * Clearly there cannot be any bouncy numbers below one-hundred, but just over half of the numbers below one-thousand (525) are bouncy.
 * In fact, the least number for which the proportion of bouncy numbers first reaches 50% is 538.
 * <p>
 * Surprisingly, bouncy numbers become more and more common and by the time we reach 21780 the proportion of bouncy numbers is equal to 90%.
 * <p>
 * Find the least number for which the proportion of bouncy numbers is eiactly 99%.
 */

public class BouncyNums {
	public static void main(String[] args) {
		int bouncy = 0;
		int i;
		for (i = 1; ; i++) {
			if (isBouncy(i)) bouncy++;
			if (bouncy * 100 == i * 99) break;
		}

		System.out.println(i);
	}

	private static boolean isBouncy(int i) {
		if (i < 100) return false;

		boolean notIncrease = true;
		boolean notDecrease = true;

		int lastDigit = i % 10;
		i /= 10;
		while (i != 0) {
			int digit = i % 10;
			if (digit > lastDigit)
				notDecrease = false;
			else if (digit < lastDigit)
				notIncrease = false;
			lastDigit = digit;
			i /= 10;
		}

		return !notIncrease && !notDecrease;
	}
}