/**
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        helper(root, maxSum);
        return maxSum[0];
    }

    private int helper(TreeNode root, int[] maxSum) {
        if (root == null) return 0;
        int leftSum = helper(root.left, maxSum);
        int rightSum = helper(root.right, maxSum);
        int arch = leftSum + root.val + rightSum;
        int maxRootToParent = Math.max(root.val, Math.max(leftSum, rightSum) + root.val);
        maxSum[0] = Math.max(maxSum[0], Math.max(arch, maxRootToParent));
        return maxRootToParent;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}