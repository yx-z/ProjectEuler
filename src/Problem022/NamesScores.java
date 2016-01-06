package Problem022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Problem 22:
 * Using names.txt, a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */

public class NamesScores {
    public static void main(String[] args) throws IOException {
        String[] file = readFile("src/Problem022/names.txt");
        System.out.println("Ans: " + calSum(file));
    }

    private static String[] readFile(String fileName) throws IOException {
        String[] file;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        if (line.isEmpty()) return null;
        bufferedReader.close();

        file = line.split(",");
        Arrays.sort(file);

        return file;
    }

    private static long calSum(String[] file) {
        long ans = 0;
        for (int i = 0; i < file.length; i++)
            ans += (i + 1) * calVal(file[i]);
        return ans;
    }

    public static int calVal(String name) {
        int worth = 0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < name.length(); i++)
            worth += (alphabet.indexOf(name.charAt(i)) + 1);
        return worth;
    }
}
