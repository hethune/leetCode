/**
 * http://oj.leetcode.com/problems/sqrtx/
 * Created by wenhang on 3/3/14.
 */
public class Solution {
    public int sqrt(int x) {
        // f(x) = x^2 - r = 0
        // f'(x) = 2x
        // f(x)/f'(x) = x^2 - r / 2x
        // x(n+1) = x(n) - x^2 - r / 2x
        double x0 = ((double)x) / 10;
        int x1 = (int) x0;
        int t = 0;
        while (t <= 30) {
            x0 = x0 - (x0*x0 - x) / (2*x0);
            x1 = (int) x0;
            t++;
        }
        return x1;
    }
}