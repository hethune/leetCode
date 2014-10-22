class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        if (len(A) + len(B)) & 1:
            return self.getElement(A, B, (len(A) + len(B))/2 + 1)
        else:
            return (self.getElement(A, B, (len(A) + len(B))/2) + self.getElement(A, B, (len(A) + len(B))/2 + 1)) / 2.0

    def getElement(self, A, B, k):

        # print A, B, k

        if A is None and B is None:
            return
        if A is None or len(A) == 0:
            return B[k-1]
        if B is None or len(B) == 0:
            return A[k-1]
        if k <= 1:
            return min(A[0], B[0])

        if B[len(B)/2] > A[len(A)/2]:
            if len(A)/2 + len(B)/2 + 1 >= k:
                return self.getElement(A, B[0:len(B)/2], k)
            else:
                return self.getElement(A[(len(A)/2 + 1):], B, k - len(A)/2  -1)
        else:
            if len(A)/2 + len(B)/2 + 1 >= k:
                return self.getElement(A[0:len(A)/2], B, k)
            else:
                return self.getElement(A, B[(len(B)/2 + 1):], k - len(B)/2 -1)

A = [1, 3, 7, 9]
B = [2]

s = Solution()  

print s.findMedianSortedArrays(A, B)