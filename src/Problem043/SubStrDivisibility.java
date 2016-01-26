package Problem043;

/**
 * The number, 1406357289, is a 0 to 9 panditialsdigital number because it is made up of each of the digits 0 to 9 in some order,
 * but it also has a rather interesting sub-string divisibility property.
 * <p>
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * <p>
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * <p>
 * Find the sum of all 0 to 9 panditialsdigital numbers with this property.
 */

/*
    d2d3d4 % 2 == 0 -> d4 can either be 0,2,4,6,8
    d3d4d5 % 3 == 0 -> d3+d4+d5 is a multiple of 3
    d4d5d6 % 5 == 0 -> d6 can either be 0,5
    d6d7d8 % 11 == 0 -> if d6 is 0 then d6d7d8 can only be 011 022 033 ... which is not allowed -> d6 = 5
 */

public class SubStrDivisibility {
    //primes to be checked
    private static int[] primesTo17 = new int[]{2, 3, 5, 7, 11, 13, 17};
    //possible digitsutations of nums
    private static int[] digits = {1, 0, 2, 3, 4, 5, 6, 7, 8, 9};
    //stores ans
    private static long sum = 0;

    public static void main(String[] args) {
        run(primesTo17.length - 1, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        System.out.println(sum);
    }

    public static void run(int p, int[] previous) {
        if (p <= -1) {
            long n =
                    concat(previous[0], concat(previous[1] % 10,
                            concat(previous[2] % 10, concat(previous[3] % 10,
                                    concat(previous[4] % 10, concat(previous[5] % 10, previous[6] % 10))))));
            if (!distinct(n)) return;
            long panditials = makePanditials(n);
            if (n == panditials) return;
            sum += panditials;
            return;
        }

        //check if the num meets the conditions
        for (int i = primesTo17[p]; i < 1000; i += primesTo17[p]) {
            if (!distinct(i) || (p < primesTo17.length - 1 && previous[p + 1] / 10 != i % 100)) continue;
            previous[p] = i;
            run(p - 1, previous);
        }
    }

    public static boolean distinct(long n) {
        boolean[] digits = new boolean[10];

        while (n > 0) {
            if (digits[(int) n % 10]) return false;
            digits[(int) n % 10] = true;
            n /= 10;
        }

        return true;
    }

    public static long makePanditials(long n) {
        boolean[] digits = new boolean[10];
        long oriNum = n, newNum = 0L;

        while (n > 0) {
            digits[(int) n % 10] = true;
            n /= 10;
        }

        for (long i = 0; i < 10; i++)
            if (!digits[(int) i]) {
                if (newNum != 0) return oriNum;
                newNum = concat(i, oriNum);
            }

        return newNum != 0 ? newNum : oriNum;    }

    //util method for concatinating two nums
    public static long concat(long a, long b) {
        return Long.parseLong("" + a + b);
    }
}