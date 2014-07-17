from solution import Solution
from pprint import pprint

board1 = [['X', 'X', 'X', 'X', 'X'],
         ['X', '0', '0', 'X', 'X'],
         ['X', 'X', '0', '0', 'X'],
         ['X', '0', 'X', 'X', 'X'],]
board2 = []

board3 = [['X', 'X', 'X'],
          ['X', '0', 'X'],
          ['X', 'X', 'X']]

board = board3
sol = Solution()
sol.solve(board)
pprint(board)