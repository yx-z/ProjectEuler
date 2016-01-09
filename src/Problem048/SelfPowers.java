package Problem048;

import java.math.BigInteger;

/**
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * <p>
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

public class SelfPowers {
    public static void main(String[] args) {
        BigInteger result = new BigInteger("0");
        for (int i = 1; i <= 1000; i++)
            result = result.add(new BigInteger(""+i).pow(i));

        System.out.println(result.toString().substring(result.toString().length() - 10,result.toString().length()));
    }
}
