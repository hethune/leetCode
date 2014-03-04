/**
 * http://oj.leetcode.com/problems/valid-number/
 * Created by wenhang on 2/20/14.
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) {
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                return true;
            } else {
                return false;
            }
        }

        s = s.trim();
        boolean hasBeenValid = false;
        boolean hasBeenScientific = false;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == 'e' || c == 'E') {
                if (!hasBeenValid || hasBeenScientific) {
                    return false;
                } else {
                    hasBeenScientific = true;
                }
            }
            if (c < '0' || c > '9') {
                if (!hasBeenScientific && (c == 'e' || c == 'E')) {
                    return false;
                }
            }

            hasBeenValid = true;
        }
        return true;
    }
}