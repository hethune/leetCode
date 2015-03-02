# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
    def __str__(self):
        return str(self.val)
    def output(self):
        print self.val
        cur = self.next
        while cur is not None:
            print cur.val
            cur = cur.next

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if head is None or head.next is None:
            return head
        if head.val == head.next.val:
            while head.next is not None and head.next.val == head.val:
                head = head.next
            return self.deleteDuplicates(head.next)
        else:
            head.next = self.deleteDuplicates(head.next)
            return head

def makeListNode(valList):
    head = ListNode(None)
    cur = head
    for val in valList[:-1]:
        cur.val = val
        cur.next = ListNode(None)
        cur = cur.next
    cur.val = valList[-1]
    return head

s = Solution()
vals = [1, 1, 2, 3, 3, 4, 4, 4, 5]
valsList = makeListNode(vals)
# print valsList.output()
print s.deleteDuplicates(valsList).output()

