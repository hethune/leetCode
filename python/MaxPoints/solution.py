# Definition for a point
import sys
from pprint import pprint
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution:
    def slope(self, p1, p2):
        return 2147483648 if p1.y == p2.y else float(p1.x - p2.x) / (p1.y - p2.y)
    def equal(self, p1, p2):
        return True if p1.x == p2.x and p1.y == p2.y else False 
    # @param points, a list of Points
    # @return an integer
    def maxPoints(self, points):
        maxNum = 0
        for index, p in enumerate(points):
            localMax = 0
            samePoint = 1
            localDict = {}
            for q in points[index + 1 : ]:
                if (self.equal(p, q)):
                    samePoint += 1
                    continue
                k = self.slope(p, q)
                if k in localDict:
                    localDict[k] += 1
                else:
                    localDict[k] = 1
                if localDict[k] > localMax:
                    localMax = localDict[k]
            localMax += samePoint
            if localMax > maxNum:
                maxNum = localMax
        return maxNum