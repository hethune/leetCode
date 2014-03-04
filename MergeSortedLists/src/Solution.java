/**
 * Definition for singly-linked list.
 * http://oj.leetcode.com/problems/merge-two-sorted-lists/
 * Assume the lists are both ascendant.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        ListNode head;
        ListNode small;
        ListNode large;
        if (l1.val <= l2.val) {
            head = l1;
            small = l1;
            large = l2;
        } else {
            head = l2;
            small = l2;
            large = l1;
        }
        if (small.next == null) {
            small.next = large;
        } else {
            while (small.next.val <= large.val) {
                small = small.next;
                if (small.next == null) {
                    break;
                }
            }
            small.next = mergeTwoLists(small.next, large);
        }
        return head;
    }
}
