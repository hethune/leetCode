from flattenTree import Solution, Util, TreeNode

s = Solution()
util = Util()

root = TreeNode(0)
root.left = TreeNode(1)
root.right = TreeNode(2)
root.left.left = TreeNode(3)

util.printTreeValue(root)

s.flatten(root)

util.printTreeValue(root)