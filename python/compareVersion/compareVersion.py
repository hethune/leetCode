class Solution:
    def getNumbers(self, version):
        numbers = map(lambda y: int(y), map(lambda x: x.lstrip("0") if x.lstrip("0") != "" else 0, version.split('.')))
        # print numbers
        return numbers
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        version1Numbers = self.getNumbers(version1)
        version2Numbers = self.getNumbers(version2)

        lenDiff = abs(len(version1Numbers) - len(version2Numbers))
        if (lenDiff > 0):
            paddingZeros = [0 for i in range(lenDiff)]
            if len(version1Numbers) < len(version2Numbers):
                version1Numbers = version1Numbers +paddingZeros
            else:
             version2Numbers = version2Numbers + paddingZeros

        # print version1Numbers
        # print version2Numbers
        minLength = len(version1Numbers)

        for i in range(minLength):
            if version1Numbers > version2Numbers:
                return 1
            elif version1Numbers < version2Numbers:
                return -1

        if len(version1Numbers) == len(version2Numbers):
            return 0

        return 1 if len(version1Numbers) > len(version2Numbers) else -1;

s = Solution()

print s.compareVersion("1.0", "1")