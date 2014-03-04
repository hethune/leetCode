/**
 * http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        this.head = head;
        ListNode tmp = head;
        int len = 1;
        while (tmp.next != null) {
            len++;
            tmp = tmp.next;
        }
        return sortedListToBST(0, len - 1);
    }

    public TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode left = sortedListToBST(start, middle - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        TreeNode right = sortedListToBST(middle + 1, end);
        root.right = right;
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}