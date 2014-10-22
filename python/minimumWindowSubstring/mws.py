class Solution:
    # @return a string
    def minWindow(self, S, T):
        minLength = len(S) + 2
        minWindow = ''
        if T == '' or len(T) > len(S):
            return minWindow
        wordMap = {}
        wordMinMap = {}

        for t in T:
            wordMap[t] = 0
            wordMinMap[t] = 1 if t not in wordMinMap.keys() else wordMinMap[t] + 1
        # print(wordMinMap)

        i = 0
        j = 1
        while j <= len(S):
            if S[j-1] in wordMap:
                wordMap[S[j-1]] += 1
            # print S[i:j]
            # print wordMap
            if self.compareDict(wordMap, wordMinMap):
                while (i < j):
                    i += 1
                    # print i-1, S[i-1]
                    if (S[i-1] in wordMap):
                        wordMap[S[i-1]] -= 1
                    if not self.compareDict(wordMap, wordMinMap):
                        i -= 1
                        if (S[i] in wordMap):
                            wordMap[S[i]] += 1
                        break
                if (j - i + 1 < minLength):
                    minWindow = S[i:j]
                    minLength = j - i + 1
            j += 1

        return minWindow

    def compareDict(self, wordMap1, wordMap2):
        for key in wordMap1.keys():
            if wordMap1[key] < wordMap2[key]:
                return False
        return True

s = Solution()
S = "ADOBECODEBANC"
T = "ABC"

S = "a"
T = "a"
print(s.minWindow(S, T))
