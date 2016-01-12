package Problem042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 * <p>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <p>
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
 * <p>
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words.
 * How many are triangle words?
 */

public class CodedTriNum {
    public static void main(String[] args) throws IOException {
        String[] file = readFile("src/Problem042/words.txt");
        int counter = 0;
        for (String str : file)
            if (isTriNum(sumOfWords(str))) counter++;
        System.out.println(counter);
    }

    private static String[] readFile(String fileName) throws IOException {
        String[] file;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        if (line.isEmpty()) return null;
        bufferedReader.close();

        file = line.split(",");

        return file;
    }

    private static int sumOfWords(String str) {
        int ans = 0;
        str = str.toUpperCase();
        String wordModel = "\"ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < str.length(); i++)
            ans += wordModel.indexOf(str.charAt(i));
        return ans;
    }

    private static boolean isTriNum(int num) {
        int tmp = 2 * num;
        for (int i = 1; i <= tmp / 2; i++)
            if (tmp == i * (i + 1)) return true;
        return false;
    }
}