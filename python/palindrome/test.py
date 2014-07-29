import random
import unittest
from palindrome import Solution

class TestPalindrome(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_panlindrome(self):
        s = None
        self.assertEqual(self.solution.panlindrome(s), 1)
        s = 'ab'
        self.assertEqual(self.solution.panlindrome(s), 0)
        s = 'aa'
        self.assertEqual(self.solution.panlindrome(s), 1)
        s = 'aba'
        self.assertEqual(self.solution.panlindrome(s), 1)
        s = 'abba'
        self.assertEqual(self.solution.panlindrome(s), 1)

    def test_solution(self):
        s = None
        self.assertEqual(self.solution.minCut(s), 0)
        s = 'a'
        self.assertEqual(self.solution.minCut(s), 0)
        s = 'ab'
        self.assertEqual(self.solution.minCut(s), 1)
        s = 'aa'
        self.assertEqual(self.solution.minCut(s), 0)
        s = 'abba'
        self.assertEqual(self.solution.minCut(s), 0)
        s = 'abdaba'
        self.assertEqual(self.solution.minCut(s), 3)
        s = 'efe'
        self.assertEqual(self.solution.minCut(s), 0)

if __name__ == '__main__':
    unittest.main()
