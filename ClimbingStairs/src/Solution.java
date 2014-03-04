import java.util.HashMap;

/**
 * Created by wenhang on 2/10/14.
 * http://oj.leetcode.com/problems/climbing-stairs/
 */

public class Solution {
    private static HashMap<Integer, Integer> cachedResults = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if (n <= 0 ) return 1;
        if (n == 1 ) return 1;
        if (cachedResults.containsKey(n)) {
            return cachedResults.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            cachedResults.put(n, result);
            return result;
        }
    }

    private static final int[][] A = {{1, 1}, {1, 0}};
    private static final int[][] I = {{1, 0}, {0, 1}};
    public int climbStairs2(int n) {
        int[][] an = matrixPow(A, n);
        return an[0][0] + an[1][0];
    }

    public static int[][] matrixPow(int[][] A, int n) {
        int[][] tmp = A;
        int[][] result = I;
        int i = n - 1;
        while (i > 0) {
            if ((i & 1) == 1) {
                result = matrixMultiply(result, tmp);
            }
            tmp = matrixMultiply(tmp, tmp);
            i >>= 1;
        }
        return result;
    }

    public static int[][] matrixMultiply(int a[][], int b[][]) {
        int aRows = a.length,
                aColumns = a[0].length,
                bRows = b.length,
                bColumns = b[0].length;

        if ( aColumns != bRows ) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        int[][] resultant = new int[aRows][bColumns];

        for(int i = 0; i < aRows; i++) { // aRow
            for(int j = 0; j < bColumns; j++) { // bColumn
                for(int k = 0; k < aColumns; k++) { // aColumn
                    resultant[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return resultant;
    }
}