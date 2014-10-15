class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return a list of lists of string
    def findLadders(self, start, end, dict):
        results = []

        if start not in dict or end not in dict:
            return results

        if start == end:
            results.append([start])
            return results

