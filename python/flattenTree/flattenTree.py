from pprint import pprint

# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Util:
    def printTreeValue(self, head):
        values = []
        nodes = []
        nodes.append(head)
        while len(nodes) != 0:
            node = nodes.pop(0)
            if node == None:
                values.append(None)
                continue
            values.append(node.val)
            if node.left == None and node.right == None:
                continue
            nodes.append(node.left)
            nodes.append(node.right)
        pprint(values)

class Solution:
    # @param root, a tree node
    # @return nothing, do it in place
    def flatten(self, root):
        if root == None:
            return
        left = root.left
        right = root.right
        root.left = None
        root.right = self.flatten(left)
        tmp = root
        while tmp.right != None:
            tmp = tmp.right
        tmp.right = self.flatten(right)
        return root