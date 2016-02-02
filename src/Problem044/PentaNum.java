package Problem044;

/**
 * Pentagonal numbers are generated by the formula, Pn = n(3n−1)/2. The first ten pentagonal numbers are:
 * <p>
 * 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
 * <p>
 * It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference, 70 − 22 = 48, is not pentagonal.
 * <p>
 * Find the pair of pentagonal numbers, Pj and Pk,
 * for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised; what is the value of D?
 */

public class PentaNum {
    public static void main(String[] args) {
        int result;

        terminate:
        //check from bottom up
        for (int i = 2; ; i++) {
            //get the first pentagonal num
            int n = i * (3 * i - 1) / 2;
            //check from top down in order to minimize the difference
            for (int j = i - 1; j > 0; j--) {
                //get the second pentagonal num
                int m = j * (3 * j - 1) / 2;
                //check the condition
                if (isPenta(n - m) && isPenta(n + m)) {
                    result = n - m;
                    break terminate;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isPenta(int number) {
        double tmp = (Math.sqrt(1 + 24 * number) + 1.0) / 6.0;
        return tmp == (int) tmp;
    }
}