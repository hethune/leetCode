# https://oj.leetcode.com/problems/n-queens-ii/
# Follow up for N-Queens problem.
# Now, instead outputting board configurations, return the total number of distinct solutions.
#
# Author: Tony Wen

class Solution:
    ans, limit = 0, 0
    # @return an integer
    def totalNQueens(self, n):
        self.ans = 0
        self.limit = (1 << n) - 1
        self.test(0, 0 ,0)
        return self.ans
    def test(self, row, ld, rd):
        if row == self.limit:
            self.ans += 1
            return
        pos = self.limit & (~(row|ld|rd))
        while pos:
            p = pos & (-pos)
            pos -= p
            self.test(row+p, (ld+p)<<1, (rd+p)>>1)
    