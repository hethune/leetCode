from sameTree import Solution, TreeNode

s = Solution()
t1 = TreeNode(1)
t1.left = TreeNode(2)
t1.left.right = TreeNode(3)

t2 = TreeNode(1)
t2.left = TreeNode(2)
t2.left.right = None

print s.isSameTree(t1, t2)