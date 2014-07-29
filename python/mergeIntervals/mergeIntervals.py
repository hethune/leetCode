# Definition for an interval.
from pprint import pprint
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval
    def merge(self, intervals):
        if intervals is None or len(intervals) <= 1:
            return intervals
        intervals = sorted(intervals, key=lambda interval: interval.start)
        merged = [intervals[0]]
        for interval in intervals[1:]:
            merged = self.insert(merged, interval)
        return merged
    # assume intervals are sorted
    def insert(self, intervals, interval):
        if intervals is None or interval is None:
            return None
        # newIntervals = copy.deepcopy(intervals)
        inserted = 0
        elementsToRemove = []
        for idx, val in enumerate(intervals):
            if val.start > interval.end:
                intervals[idx:idx] = [interval]
                inserted = 1
                break
            if val.end < interval.start:
                continue
            interval.start = val.start if val.start < interval.start else interval.start
            interval.end = val.end if val.end > interval.end else interval.end
            elementsToRemove.append(val)
        for e in elementsToRemove:
            intervals.remove(e)
        if inserted == 0:
            intervals.append(interval)
        return intervals
