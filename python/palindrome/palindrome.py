from pprint import pprint
class Solution:
    # @param s, a string
    # @return an integer
    def minCut(self, s):
        if s is None or len(s) == 0 or len(s) == 1:
            return 0
        self.min = 2147483648
        self.dp = [x for x in range(len(s), -1, -1)]
        self.pan = [[0 for x in range(len(s))] for y in range(len(s))]
        for i in range(len(s)-1, -1, -1):
            for j in range(i, len(s)):
                if s[i] == s[j] and (j-i < 2 or self.pan[i+1][j-1] == 1):
                    self.pan[i][j] = 1
                    self.dp[i] = min(self.dp[i], self.dp[j+1] + 1)
        return self.dp[0] - 1
    def panlindrome(self, s):
        if (s is None) or (len(s) ==0) or (len(s) == 1):
            return 1
        if s[0] == s[len(s)-1]:
            return self.panlindrome(s[1:len(s)-1])
        return 0