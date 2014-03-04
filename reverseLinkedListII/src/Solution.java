/**
 * Author: Tony Hang Wen
 * http://oj.leetcode.com/problems/reverse-linked-list-ii/
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) { return null; }
        if (m == n) { return head; }
        ListNode curr = head;
        ListNode prev = null;
        ListNode ans = null;

        int index = 1;
        while (index < m) {
            prev = curr;
            curr = curr.next;
            index++;
            if (curr == null) {
                System.err.println("Start index exceeded Linkedlist length");
                return null;
            }
        }

        ListNode newHead = invert(curr, n-m+1);
        if (prev != null) {
            prev.next = newHead;
            ans = head;
        } else {
            ans = newHead;
        }

        return ans;
    }

    public ListNode invert(ListNode head) {
        return invert(head, Integer.MAX_VALUE);
    }

    public ListNode invert(ListNode head, int n) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        if (head == null) return null;
        int index = 0;
        while (index < n) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            if (next == null) break;
            curr = next;
            index++;
        }
        head.next = next;
        return prev;

    }
}