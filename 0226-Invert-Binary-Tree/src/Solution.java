class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode prevRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(prevRight);
        return root;
    }
}