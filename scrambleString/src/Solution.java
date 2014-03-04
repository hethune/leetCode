/**
 * http://oj.leetcode.com/problems/scramble-string/
 * Created by wenhang on 3/3/14.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int l = s1.length();
        int[][][] dp = new int[l][l][l];
        int i, j, k;
        for (i = 0; i < l; i++) {
            for (j = 0; j < l; j++) {
                for (k = 0; k < l; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return isScramble(s1, s2, dp, 0, 0, l);
    }

    protected boolean isScramble(String s1, String s2, int[][][] dp, int start1, int start2, int l) {
        if (dp[start1][start2][l-1] != -1) {
            return (dp[start1][start2][l-1] == 1);
        }
        String ss1 = s1.substring(start1, start1 + l);
        String ss2 = s2.substring(start2, start2 + l);
        if (ss1.equals(ss2)) {
            dp[start1][start2][l-1] = 1;
            return true;
        }

        for (int i = 1; i < l; i++) {
            if (isScramble(s1, s2, dp, start1, start2, i) && isScramble(s1, s2, dp, start1 + i, start2 + i, l - i)) {
                dp[start1][start2][l-1] = 1;
                return true;
            }

            if (isScramble(s1, s2, dp, start1, start2 + l - i, i) && isScramble(s1, s2, dp, start1 + i, start2, l - i)) {
                dp[start1][start2][l-1] = 1;
                return true;
            }
        }

        dp[start1][start2][l-1] = 0;
        return false;

    }
}