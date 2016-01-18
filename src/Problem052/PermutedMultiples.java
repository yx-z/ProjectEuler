package Problem052;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */

public class PermutedMultiples {
    public static void main(String[] args) {
        int n = 1;
        //get n until it is permuted multiple
        while (!isPermutedMultiple(n)) n++;
        System.out.println(n);
    }

    //ex. 1123->[0=0,1=2,2=1,3=1,4~9=0]
    private static HashMap<Integer, Integer> getDigitsCount(long num) {
        HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>() {{
            for (int i = 0; i < 10; i++)
                this.put(i, 0);
        }};
        String str = "" + num;
        for (int i = 0; i < str.length(); i++) {
            int currentDigit = Integer.parseInt("" + str.charAt(i));
            ans.replace(currentDigit, ans.get(currentDigit) + 1);//each time plus one of the value to the specific key
        }
        return ans;
    }

    //check if two hashMap is equal
    private static boolean equalsEachDigitCount(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < 10; i++)
            if (a.get(i) != b.get(i)) return false;
        return true;
    }

    //num, 2 * num , 3 * num, ... , 6 * num are all equalEachDigitCoount
    private static boolean isPermutedMultiple(long num) {
        ArrayList<HashMap<Integer, Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            tmp.add(i, getDigitsCount(num * (i + 1)));
        for (int i = 0; i < 5; i++)
            if (!equalsEachDigitCount(tmp.get(i), tmp.get(i + 1))) return false;
        return true;
    }
}