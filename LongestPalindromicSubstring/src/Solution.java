/**
 * oj.leetcode.com/problems/longest-palindromic-substring/
 * Created by wenhang on 3/4/14.
 */
public class Solution {
    public String longestPalindrome(String s) {
        //d[i][j] s[i] to s[j] is a palindrome
        if (s == null || s.length() == 0) { return new String(); }
        int[][] d = new int[s.length()][s.length()];
        int i, j;
        for (i = 0; i < s.length(); i++) {
            for (j = i; j < s.length(); j++) {
                d[i][j] = -1;
            }
        }
        for (i = 0; i < s.length(); i++) {
            for (j = i; j < s.length(); j++) {
                update(s, d, i, j);
            }
        }

        int start = 0; int end = 0;
        for (i = 0; i < s.length(); i++) {
            for (j = s.length() - 1; j >= i; j--) {
                if (d[i][j] == 1) {
                    if ((j - i) > (end - start)) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private void update(String s, int[][] d, int start, int end) {
        if (d[start][end] != -1) return;
        if (start > end) { System.err.println("error"); System.exit(1); }
        if (start == end) { d[start][end] = 1; return;}
        if (start == end - 1) { d[start][end] = (s.charAt(start) == s.charAt(end)) ? 1 : 0; return ;}
        if (s.charAt(start) != s.charAt(end)) { d[start][end] = 0; return; }
        if (d[start+1][end-1] == -1) {
            update(s, d, start+1, end - 1);
        }
        d[start][end] = ((d[start+1][end-1] == 1) && (s.charAt(start) == s.charAt(end))) ? 1 : 0;
    }
}
