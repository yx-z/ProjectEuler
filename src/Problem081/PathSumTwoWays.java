package Problem081;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * In the 5 by 5 matrix below(omitted), the minimal path sum from the top left to the bottom right,
 * by only moving to the right and down, is indicated in bold red and is equal to 2427.
 * Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."),
 * a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right by only moving right and down.
 */

public class PathSumTwoWays {
    private static final int SIZE = 80;

    //strategy: DP
    public static void main(String[] args) throws IOException {
        int[][] matrix = readFile("src/Problem081/matrix.txt");

        for (int y = matrix.length - 1; y >= 0; y--)
            for (int x = matrix[0].length - 1; x >= 0; x--)
                if (x + 1 < matrix.length && y + 1 < matrix[x].length)
                    matrix[x][y] += Math.min(matrix[x + 1][y], matrix[x][y + 1]);
                    //dealing with sides
                else if (x + 1 < matrix[0].length)
                    matrix[x][y] += matrix[x + 1][y];
                else if (y + 1 < matrix.length)
                    matrix[x][y] += matrix[x][y + 1];

        System.out.println(matrix[0][0]);
    }

    //get a SIZE by SIZE matrix
    private static int[][] readFile(String fileName) throws IOException {
        int[][] matrix = new int[SIZE][SIZE];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        int lineNum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineArr = line.split(",");
            for (int i = 0; i < SIZE; i++)
                matrix[lineNum][i] = Integer.parseInt(lineArr[i]);
            lineNum++;
        }

        return matrix;
    }
}