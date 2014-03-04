/**
 * Created by wenhang on 2/10/14.
 */

/**
 * http://oj.leetcode.com/problems/linked-list-cycle/
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;

        if (head == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head;

        while (true) {
            if (second.next != null) {
                second = second.next;
                if (second == first) { hasCycle = true; break; }
                if (second.next != null) {
                    second = second.next;
                } else {
                    break;
                }
            } else {
                break;
            }

            if (first.next != null) {
                first = first.next;
            }

        }
        return hasCycle;
    }
}