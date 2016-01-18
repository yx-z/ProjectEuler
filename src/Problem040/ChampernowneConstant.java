package Problem040;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 * <p>
 * 0.123456789101112131415161718192021...
 * <p>
 * It can be seen that the 12th digit of the fractional part is 1.
 * <p>
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 * <p>
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */

public class ChampernowneConstant {
    public static void main(String[] args) {
        //by using charAt, it is easy to figure out the answer.
        final int UPPER_LIMIT = 1000000;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < UPPER_LIMIT; i++)
            sb.append(i);
        int ans = 1;
        for (int i = 0; i <= 6; i++)
            ans *= sb.charAt((int)Math.pow(10, i) - 1) - '0';
        System.out.println(ans);
    }
}
