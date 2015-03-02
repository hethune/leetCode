class Solution:
    # @param s, a string
    # @return a list of strings
    def findRepeatedDnaSequences(self, s):
        bitLength = 10
        if s is None or len(s) <= bitLength:
            return []
        keySet = set()
        resultSet = set()
        for index in range(len(s) - bitLength + 1):
            print index
            dnaSeq = s[index: index + bitLength]
            if dnaSeq in keySet:
                resultSet.add(dnaSeq)
            else:
                keySet.add(dnaSeq)

        return list(resultSet)

s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
s = "AAAAAAAAAAA"
sol = Solution()
print sol.findRepeatedDnaSequences(s)
