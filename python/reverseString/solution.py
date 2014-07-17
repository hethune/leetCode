class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        if s is None:
            return
        s = s.strip()
        words = s.split()
        words.reverse()
        s = " ".join(words)
        return s