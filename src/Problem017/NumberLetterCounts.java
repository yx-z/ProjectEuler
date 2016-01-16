package Problem017;

import java.util.HashMap;

/**
 * If the numbers 1 to 5 are written out in words:
 * one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens.
 * For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */

public class NumberLetterCounts {
    //initialize a hashmap to convert numbers to its English
    private static HashMap<Integer, String> numTrans = new HashMap<Integer, String>() {{
        this.put(0, "");
        this.put(1, "one");
        this.put(2, "two");
        this.put(3, "three");
        this.put(4, "four");
        this.put(5, "five");
        this.put(6, "six");
        this.put(7, "seven");
        this.put(8, "eight");
        this.put(9, "nine");
        this.put(10, "ten");
        this.put(11, "eleven");
        this.put(12, "twelve");
        this.put(13, "thirteen");
        this.put(14, "fourteen");
        this.put(15, "fifteen");
        this.put(16, "sixteen");
        this.put(17, "seventeen");
        this.put(18, "eighteen");
        this.put(19, "nineteen");
        this.put(20, "twenty");
        this.put(30, "thirty");
        this.put(40, "forty");
        this.put(50, "fifty");
        this.put(60, "sixty");
        this.put(70, "seventy");
        this.put(80, "eighty");
        this.put(90, "ninety");
        this.put(100, "onehundred");
        this.put(200, "twohundred");
        this.put(300, "threehundred");
        this.put(400, "fourhundred");
        this.put(500, "fivehundred");
        this.put(600, "sixhundred");
        this.put(700, "sevenhundred");
        this.put(800, "eighthundred");
        this.put(900, "ninehundred");
    }};

    public static void main(String[] args) {
        int sum = 0;
        //1 to 999
        for (int i = 1; i < 1000; i++)
            sum += toStr(i).length();
        //+1000.length
        sum += "onethousand".length();

        System.out.println("Sum: " + sum);
    }

    //1 <= n < 1000
    private static String toStr(int n) {
        //1~20
        if (n < 20 || (n < 100 && n % 10 == 0) || n % 100 == 0) return numTrans.get(n);

        int[] arr = toArr(n);
        //21~99
        if (n < 100) return numTrans.get(arr[0]) + numTrans.get(arr[1]);
        //100~119
        if (n % 100 < 20) return numTrans.get(arr[0]) + "and" + numTrans.get(arr[1] + arr[2]);
        //120~999
        return numTrans.get(arr[0]) + "and" + numTrans.get(arr[1]) + numTrans.get(arr[2]);
    }

    //ex. 123->[1,2,3]
    private static int[] toArr(int n) {
        if (n < 100) return new int[]{n - n % 10, n % 10};
        if (n < 1000) return new int[]{n - n % 100, ((n / 10) % 10) * 10, n % 10};
        return null;
    }
}