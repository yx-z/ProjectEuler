package Problem017;

import java.util.HashMap;

/**
 * Problem 17:
 * If the numbers 1 to 5 are written out in words:
 * one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens.
 * For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */

public class NumberLetterCounts {
    private static HashMap<Integer, String> numTrans = new HashMap<>();

    public static void main(String[] args) {
        numTrans.put(0, "");
        numTrans.put(1, "one");
        numTrans.put(2, "two");
        numTrans.put(3, "three");
        numTrans.put(4, "four");
        numTrans.put(5, "five");
        numTrans.put(6, "six");
        numTrans.put(7, "seven");
        numTrans.put(8, "eight");
        numTrans.put(9, "nine");
        numTrans.put(10, "ten");
        numTrans.put(11, "eleven");
        numTrans.put(12, "twelve");
        numTrans.put(13, "thirteen");
        numTrans.put(14, "fourteen");
        numTrans.put(15, "fifteen");
        numTrans.put(16, "sixteen");
        numTrans.put(17, "seventeen");
        numTrans.put(18, "eighteen");
        numTrans.put(19, "nineteen");
        numTrans.put(20, "twenty");
        numTrans.put(30, "thirty");
        numTrans.put(40, "forty");
        numTrans.put(50, "fifty");
        numTrans.put(60, "sixty");
        numTrans.put(70, "seventy");
        numTrans.put(80, "eighty");
        numTrans.put(90, "ninety");
        numTrans.put(100, "one hundred");
        numTrans.put(200, "two hundred");
        numTrans.put(300, "three hundred");
        numTrans.put(400, "four hundred");
        numTrans.put(500, "five hundred");
        numTrans.put(600, "six hundred");
        numTrans.put(700, "seven hundred");
        numTrans.put(800, "eight hundred");
        numTrans.put(900, "nine hundred");
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            sum += toStr(i).replaceAll(" ", "").length();
        sum += "onethousand".length();
        System.out.println("Sum: " + sum);
    }

    //1 <= n < 1000
    private static String toStr(int n) {
        if (n < 20 || (n < 100 && n % 10 == 0) || n % 100 == 0) return numTrans.get(n);

        int[] arr = toArr(n);
        if (n < 100) return numTrans.get(arr[0]) + numTrans.get(arr[1]);
        if (n % 100 < 20) return numTrans.get(arr[0]) + "and" + numTrans.get(arr[1] + arr[2]);
        return numTrans.get(arr[0]) + "and" + numTrans.get(arr[1]) + numTrans.get(arr[2]);
    }

    private static int[] toArr(int n) {
        if (n < 100) return new int[]{n - n % 10, n % 10};
        if (n < 1000) return new int[]{n - n % 100, ((n / 10) % 10) * 10, n % 10};
        return null;
    }


}