package Problem033;

/**
 * The fraction 49/98 is a curious fraction,
 * as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8,
 * which is correct, is obtained by cancelling the 9s.
 * <p>
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * <p>
 * There are exactly four non-trivial examples of this type of fraction, less than one in value,
 * and containing two digits in the numerator and denominator.
 * <p>
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */

public class DigitCancelFrac {
    public static void main(String[] args) {
        //initialize
        int denomProduct = 1;
        int numerProduct = 1;

        //ans must be in the form: (10 * n + i) / (10 * i + d) = n / d
        //(n < d < i)
        for (int i = 1; i < 10; i++) 
            for (int d = 1; d < i; d++)
                for (int n = 1; n < d; n++)
                    //can be digit cancelled
                    if ((n * 10 + i) * d == n * (i * 10 + d)) {
                        denomProduct *= d;
                        numerProduct *= n;
                    }
        System.out.println("denomProduct: " + denomProduct + " numerProduct: " + numerProduct);
    }
}
