import unittest
from pprint import pprint
from divide import Solution

class TestMergeIntervals(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
    def test_divide(self):
        a = 10
        b = 3
        self.assertEqual(self.solution.divide(a, b), 3)
        a = 9
        b = -2
        self.assertEqual(self.solution.divide(a, b), -4)
        self.assertEqual(self.solution.divide(b, a), 0)
        a = 2
        self.assertEqual(self.solution.divide(b, a), -1)
        a = -2147483648
        b = 2
        self.assertEqual(self.solution.divide(a, b), -1073741824)

if __name__ == '__main__':
    unittest.main()
