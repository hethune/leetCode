import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenhang on 2/9/14.
 * http://oj.leetcode.com/problems/maximum-subarray/
 */
public class Solution {
    private static List<Integer> cachedResult = new ArrayList<Integer>();
    private static int max = Integer.MIN_VALUE;
    public int maxSubArray(int[] A) {
         maxSubArrayHelper(A, A.length - 1);
        return max;
    }

    private int maxSubArrayHelper(int[] A, int index) {
        int currentMax = Integer.MIN_VALUE;
        if (A == null || index < 0 || index >= A.length + 1) { return 0; }
        int l = A.length;
        if (l == 1 || index == 0) { cachedResult.add(0, A[0]); return A[0]; }

        if (cachedResult.size() >= index) { return cachedResult.get(index); }
        currentMax = maxSubArrayHelper(A, index - 1);
        currentMax = (currentMax > 0) ? currentMax + A[index] : A[index];
        cachedResult.add(index, currentMax);
        if (max < currentMax) { max = currentMax; }
        return currentMax;
    }
}