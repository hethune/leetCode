from pprint import pprint

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Util:
    def printListAddr(self, head):
        l = []
        while head != None:
            l.append(hex(id(head)))
            head = head.next
        pprint(l)

class Solution:
    # @param a ListNode
    # @return a ListNode
    def swapPairs(self, head):
        if head == None:
            return
        if head.next == None:
            return head
        tmp = head.next.next
        headTmp = head
        head = head.next
        head.next = headTmp
        head.next.next = self.swapPairs(tmp)
        return head
