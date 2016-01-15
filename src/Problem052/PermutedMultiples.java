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
        while (!isPermutedMultiple(n)) n++;
        System.out.println(n);
    }

    private static HashMap<Integer, Integer> getDigits(long num) {
        HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>() {{
            for (int i = 0; i < 10; i++)
                this.put(i, 0);
        }};
        String str = "" + num;
        for (int i = 0; i < str.length(); i++) {
            int currentDigit = Integer.parseInt("" + str.charAt(i));
            ans.replace(currentDigit, ans.get(currentDigit) + 1);
        }
        return ans;
    }

    private static boolean equalsWithoutOrder(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {
        for (int i = 0; i < 10; i++)
            if (a.get(i) != b.get(i)) return false;
        return true;
    }

    private static boolean isPermutedMultiple(long num) {
        ArrayList<HashMap<Integer, Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            tmp.add(i, getDigits(num * (i + 1)));
        for (int i = 0; i < 5; i++)
            if (!equalsWithoutOrder(tmp.get(i), tmp.get(i + 1))) return false;
        return true;
    }
}