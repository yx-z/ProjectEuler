package Problem079;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A common security method used for online banking is to ask the user for three random characters from a passcode.
 * For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters;
 * the expected reply would be: 317.
 * <p>
 * The text file, keylog.txt, contains fifty successful login attempts.
 * <p>
 * Given that the three characters are always asked for in order,
 * analyse the file so as to determine the shortest possible secret passcode of unknown length.
 */

public class PasscodeDerivation {
    private static int[] keys;

    public static void main(String[] args) throws IOException {
        //init. & sort
        HashSet<Integer> input = readFile("src/Problem079/keylog.txt");
        keys = new int[input.size()];
        int index = 0;
        for (Integer i : input) keys[index++] = i;
        Arrays.sort(keys);

        //map each num with all numbers come after them
        HashMap<Integer, HashSet<Integer>> after = new HashMap<>();
        for (int i = 0; i < 10; i++) after.put(i, getAfter(i));
        //map each num with all numbers come before them
        HashMap<Integer, HashSet<Integer>> before = new HashMap<>();
        for (int i = 0; i < 10; i++) before.put(i, getBefore(i));

        //collect digits
        StringBuilder ans = new StringBuilder();

        //ignore numbers with no occurence in all trials at all, ...
        HashSet<Integer> ignoreSet = new HashSet<>();
        for (int i = 0; i < 10; i++)
            if (after.get(i).isEmpty() && before.get(i).isEmpty()) ignoreSet.add(i);
        //..., and remove them
        for (int i : ignoreSet) after.remove(i);

        //main loop for constructing the ans by appending nums with most priority first
        while (!after.isEmpty()) {
            int i = getMaxIndex(after, ignoreSet);
            ans.append(i);
            after.remove(i);
            ignoreSet.add(i);
        }

        System.out.println(ans);
    }

    //use HashSet to exclude duplicated info.
    private static HashSet<Integer> readFile(String fileName) throws IOException {
        HashSet<Integer> file = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                file.add(Integer.parseInt(line));
                line = br.readLine();
            }
        }
        return file;
    }

    private static HashSet<Integer> getAfter(int i) {
        HashSet<Integer> after = new HashSet<>();
        for (int k : keys) {
            String toStr = "" + k;
            int index = toStr.indexOf("" + i);
            //if this trial is related to i
            if (index >= 0)
                //get all remaining characters
                for (int j = index + 1; j < toStr.length(); j++)
                    after.add(Integer.parseInt("" + toStr.charAt(j)));
        }
        return after;
    }

    //similar to getAfter
    private static HashSet<Integer> getBefore(int i) {
        HashSet<Integer> before = new HashSet<>();
        for (int k : keys) {
            String toStr = "" + k;
            int index = toStr.indexOf("" + i);
            if (index > 0)
                for (int j = index - 1; j >= 0; j--)
                    before.add(Integer.parseInt("" + toStr.charAt(j)));
        }
        return before;
    }

    //get the num with most priority
    private static int getMaxIndex(HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> ignoreSet) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (ignoreSet.contains(i)) continue;
            if (map.get(i).size() > max) {
                max = map.get(i).size();
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}