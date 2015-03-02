from pprint import pprint

class Solution:
    # @param dungeon, a list of lists of integers
    # @return a integer
    def calculateMinimumHP(self, dungeon):
        if dungeon is None or len(dungeon) < 1:
            return None
        m = len(dungeon)
        n = len(dungeon[0])
        scores = [[None for x in range(n)] for y in range(m)]
        return self.findMinScore(dungeon, scores, 0, 0)

    def findMinScore(self, dungeon, scores, m, n):
        if m >= len(scores) or m < 0 or n >= len(scores[0]) or n < 0:
            return None
        if scores[m][n] is not None:
            return scores[m][n]

        rightScore = self.findMinScore(dungeon, scores, m, n+1)
        downScore = self.findMinScore(dungeon, scores, m+1, n)

        prevScore = None

        

        if rightScore is None and downScore is None:
            scores[m][n] = 1 - dungeon[m][n]
        elif rightScore is None:
            scores[m][n] = downScore - dungeon[m][n]
        elif downScore is None:
            scores[m][n] = rightScore - dungeon[m][n]
        else:
            scores[m][n] = min(downScore, rightScore) - dungeon[m][n]

        if scores[m][n] <= 0:
            scores[m][n] = 1

        # print m, n
        # pprint(scores)

        return scores[m][n]


# board = [[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]
# board = [[1,-3,3],[0,-2,0],[-3,-3,-3]]
board = [[100]]
# board = [[0, -3]]
sol = Solution()
print sol.calculateMinimumHP(board)