from pprint import pprint
class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
    results = []
    resultsMap = {}
    def wordBreak(self, s, dict):
        self.resultsMap = {}
        self.results = []
        return self.wordBreakHelper(s, 0 ,dict)

    def wordBreakHelper(self, s, start, dict):
        result = []
        if start in self.resultsMap:
            return self.resultsMap[start]

        for d in dict:
            if s.startswith(d, start):
                if start + len(d) == len(s):
                    result += [d]
                tmp = []
                tmp = self.wordBreakHelper(s, start + len(d), dict)
                if tmp is not None or len(tmp) > 0:
                    result += [d + ' ' + x for x in tmp]
        self.resultsMap[start] = result
        return result