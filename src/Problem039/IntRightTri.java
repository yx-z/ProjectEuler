package Problem039;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */

public class IntRightTri {
    public static void main(String[] args) {
        System.out.println(getTriAnsNum(120));
        int maxCounter = 0;
        int maxPerimeter = 0;
        for (int perimeter = 5; perimeter <= 1000; perimeter++)
            if (getTriAnsNum(perimeter) > maxCounter) {
                maxCounter = getTriAnsNum(perimeter);
                maxPerimeter = perimeter;
            }
        System.out.println(maxPerimeter);
    }

    //each side for a triangle is no bigger than half of its perimeter
    private static int getTriAnsNum(int p) {
        int counter = 0;
        for (int a = 1; a < p / 2 - 2; a++)
            for (int b = a; b < p / 2 - 1; b++)
                for (int c = b; c < p / 2; c++)
                    if (isRightTri(a, b, c, p)) counter++;
        return counter;
    }

    //For a triangle, let's assume: a <= b <= c && a + b + c == p
    private static boolean isRightTri(int a, int b, int c, int p) {
        return (a * a + b * b == c * c) && (a + b + c == p);
    }
}
