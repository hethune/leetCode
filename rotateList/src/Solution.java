/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0 || head.next == null) { return head; }
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        for (int i = 1; i < n; i++) {
            slow = fast;
            fast = fast.next;
            if (fast == null) {
                fast = head;
            }
        }
        slow.next = null;
        ListNode curr = fast;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}