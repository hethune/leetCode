class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        num = A[0]
        for number in A[ 1 : ]:
            num = num ^ number
        return num