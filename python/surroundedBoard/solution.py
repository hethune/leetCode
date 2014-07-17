from pprint import pprint

class Solution:
    # @param board, a 2D array
    # Capture all regions by modifying the input board in-place.
    # Do not return any value.
    def solve(self, board):
        l = len(board)
        if l == 0:
            return
        w = len(board[0])
        if w == 0:
            return
        marker = [[0]*w for y in range(l)]
        for i in range(l):
            self.swipe(board, i, 0, marker)
            self.swipe(board, i, w-1, marker)
        for i in range(w):
            self.swipe(board, 0, i, marker)
            self.swipe(board, l-1, i, marker)
        for i in range(l):
            for j in range(w):
                if board[i][j] == '0' and marker[i][j] == 0:
                    board[i][j] = 'X'
    def swipe(self, board, i, j, marker):
        l = len(board)
        w = len(board[0])
        if i < 0 or j < 0 or i >= l or j >= w:
            return
        if board[i][j] != '0' or marker[i][j] == 1:
            return
        marker[i][j] = 1
        self.swipe(board, i - 1, j, marker)
        self.swipe(board, i + 1, j, marker)
        self.swipe(board, i, j+1, marker)
        self.swipe(board, i, j-1, marker)