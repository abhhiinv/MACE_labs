class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None
        
        root.left, root.right = root.right, root.left  # swap
        
        self.invertTree(root.left)   # invert left subtree
        self.invertTree(root.right)  # invert right subtree
        
        return root