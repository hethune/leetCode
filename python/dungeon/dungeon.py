from pprint import pprint

class Solution:
    # @param dungeon, a list of lists of integers
    # @return a integer
    def calculateMinimumHP(self, dungeon):
        if dungeon is None or len(dungeon) < 1:
            return None
        m = len(dungeon)
        n = len(dungeon[0])
        pprint(dungeon)
        scores = [[None for x in range(n)] for y in range(m)]
        self.findMinScore(dungeon, scores, m -1, n -1)
        return (0 - scores[m-1][n-1][1]) +  1 if (0 - scores[m-1][n-1][1]) >= 0 else 1

    def findMinScore(self, dungeon, scores, m, n):
        if m == 0 and n == 0:
            scores[m][n] = [dungeon[m][n], dungeon[m][n]]
            return
        if (m - 1) >= 0 and scores[m-1][n] is None:
            self.findMinScore(dungeon, scores, m-1, n)
        if (n - 1) >= 0 and scores[m][n-1] is None:
            self.findMinScore(dungeon, scores, m, n-1)
        scores[m][n] = [None, None]
        if m > 0 and n > 0:
            if scores[m-1][n][1] > scores[m][n-1][1]:
                scores[m][n][0] = scores[m-1][n][0] + dungeon[m][n]
                scores[m][n][1] = scores[m-1][n][1] if scores[m-1][n][1] < scores[m][n][0] else scores[m][n][0]
            else:
                scores[m][n][0] = scores[m][n-1][0] + dungeon[m][n]
                scores[m][n][1] = scores[m][n-1][1] if scores[m][n-1][1] < scores[m][n][0] else scores[m][n][0]
        elif m > 0:
            scores[m][n][0] = scores[m-1][n][0] + dungeon[m][n]
            scores[m][n][1] = scores[m-1][n][1] if scores[m-1][n][1] < scores[m][n][0] else scores[m][n][0]
        elif n > 0:
            scores[m][n][0] = scores[m][n-1][0] + dungeon[m][n]
            scores[m][n][1] = scores[m][n-1][1] if scores[m][n-1][1] < scores[m][n][0] else scores[m][n][0]
        pprint(scores)
        return


board = [[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]
board = [[1,-3,3],[0,-2,0],[-3,-3,-3]]
# board = [[100]]
sol = Solution()
print sol.calculateMinimumHP(board)