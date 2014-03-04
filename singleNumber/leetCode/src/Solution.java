/**
 * Created by wenhang on 2/9/14.
 */

/**
 * http://oj.leetcode.com/problems/single-number/
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) { System.exit(1); }
        int repeatedNumber = A[0];
        for (int i = 1; i < A.length; i++ ) {
            repeatedNumber ^= A[i];
        }
        return repeatedNumber;
    }
}
