import random
import unittest
from pprint import pprint
from mergeIntervals import Solution, Interval

class TestMergeIntervals(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
    def test_mergeIntervals(self):
        #[1,3],[2,6],[8,10],[15,18],
        intervals = [Interval(1, 3), Interval(2, 6), Interval(8,10), Interval(15,18)]
        pprint(intervals)
        merged = self.solution.merge(intervals)
        pprint(merged)

if __name__ == '__main__':
    unittest.main()
