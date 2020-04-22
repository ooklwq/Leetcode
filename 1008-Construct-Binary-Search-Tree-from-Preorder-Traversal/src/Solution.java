class Solution {
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = addNode(root, preorder[i]);
        }
        return root;
    }

    private TreeNode addNode(TreeNode node, int e){
        if (node == null) return new TreeNode(e);
        if (node.val > e){
            node.left = addNode(node.left, e);
        }
        if (node.val < e){
            node.right = addNode(node.right, e);
        }
        return node;
    }
}