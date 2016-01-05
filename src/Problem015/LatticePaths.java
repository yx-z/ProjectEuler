package Problem015;

/**
 * Problem 15:
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * <p>
 * How many such routes are there through a 20×20 grid?
 */

public class LatticePaths {
    public static void main(String[] args) {
        final int gridSize = 20;

        //combination method
        long paths = 1;

        for (int i = 0; i < gridSize; i++) {
            paths *= (2 * gridSize) - i;
            paths /= i + 1;
        }

        System.out.println("Ans: " + paths);
    }
}
