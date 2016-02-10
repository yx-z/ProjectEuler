package Problem099;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Comparing two numbers written in index form like 211 and 37 is not difficult, as any calculator would confirm that 211 = 2048 < 37 = 2187.
 * <p>
 * However, confirming that 632382518061 > 519432525806 would be much more difficult, as both numbers contain over three million digits.
 * <p>
 * Using base_exp.txt (right click and 'Save Link/Target As...'),
 * a 22K text file containing one thousand lines with a base/exponent pair on each line,
 * determine which line number has the greatest numerical value.
 * <p>
 * NOTE: The first two lines in the file represent the numbers in the example given above.
 */

public class LargestExp {
	public static void main(String[] args) throws IOException {
		ArrayList<Double> input = readFile("src/Problem099/base_exp.txt");
		int maxIndex = 0;
		double max = 0;
		for (int i = 0; i < input.size(); i++) {
			System.out.println(input.get(i));
			if (input.get(i).compareTo(max) > 0) {
				max = input.get(i);
				maxIndex = i;
			}
		}
		System.out.println(maxIndex + 1);
	}

	//read rounds from .txt
	private static ArrayList<Double> readFile(String fileName) throws IOException {
		ArrayList<Double> input = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] lineArr = line.split(",");
			System.out.println(lineArr[0] + " " + lineArr[1]);
			input.add(Double.parseDouble(lineArr[1]) * Math.log(Double.parseDouble(lineArr[0])));
		}
		return input;
	}
}
