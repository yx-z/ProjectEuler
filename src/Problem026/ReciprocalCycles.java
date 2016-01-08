package Problem026;

import java.util.HashMap;
import java.util.Map;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 * <p>
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * <p>
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 * <p>
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */

public class ReciprocalCycles {
    public static void main(String[] args) {
        int num = 0;
        int maxLength = 0;
        for (int i = 2; i < 1000; i++) {
            if(getCycleLength(i) > maxLength) {
                num = i;
                maxLength = getCycleLength(i);
            }
        }
        System.out.println(num);
    }


    private static int getCycleLength(int n) {
        Map<Integer, Integer> stateToIter = new HashMap<>();
        int state = 1;
        int iter = 0;
        while (!stateToIter.containsKey(state)) {
            stateToIter.put(state, iter);
            state = state * 10 % n;
            iter++;
        }
        return iter - stateToIter.get(state);
    }
}
