/**
 * http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLevel = 1 + max(maxDepth(root.left), maxDepth(root.right));
        return  maxLevel;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
}