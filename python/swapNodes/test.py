from swapNodes import Solution, ListNode, Util

s = Solution()

util = Util()

head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)
head.next.next.next.next = ListNode(5)

util.printListAddr(head)

head = s.swapPairs(head)

util.printListAddr(head)