class Solution {
    private TreeNode prev = null;

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}