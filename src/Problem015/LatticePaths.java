package Problem015;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * <p>
 * How many such routes are there through a 20×20 grid?
 */

public class LatticePaths {
    public static void main(String[] args) {
        final int GRID_SIZE = 20;

        /*
         * mathematical-combination method, not by brutal force
         * for example, a 2 by 2 grid can be moved with LLDD,LDLD,LDDL,DLLD,DLDL,DDLL six paths with different order of
         * 2'L' and 2'D'. (Assume move from top-left corner to bottom-right corner, with L stands for left and D for down
         */
        long paths = 1;

        //loop is just for calculating the combination number
        for (int i = 0; i < GRID_SIZE; i++) {
            paths *= (2 * GRID_SIZE) - i;
            paths /= i + 1;
        }

        System.out.println("Ans: " + paths);
    }
}
