/**
 * Created by wenhang on 2/10/14.
 * http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {return;}
        if (root == null) {return;}
        LinkedList<TreeLinkNode> parent = new LinkedList<TreeLinkNode>();
        parent.add(root);
        connectLevel(parent);
    }

    private void connectLevel(LinkedList<TreeLinkNode> parent) {
        if (parent == null || parent.size() == 0) { return; }
        if (parent.peek().left == null) { return; }
        LinkedList<TreeLinkNode> children = new LinkedList<TreeLinkNode>();
        TreeLinkNode lastNode = null;
        for (TreeLinkNode t : parent) {
            children.add(t.left);
            children.add(t.right);
            t.left.next = t.right;
            if (lastNode != null) {
                lastNode.next = t.left;
            }
            lastNode = t.right;
        }
        connectLevel(children);
    }
}