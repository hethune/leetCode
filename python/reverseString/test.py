from solution import Solution
from pprint import pprint

s =  Solution()

test1 = "The   fox jumped   over    the log"
test2 = ""
test3 = None

tests = [test1, test2, test3]

for t in tests:
    pprint(s.reverseWords(t))