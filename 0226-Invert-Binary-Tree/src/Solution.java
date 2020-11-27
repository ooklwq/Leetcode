class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
//        TreeNode prevRight = root.right;
//        root.right = invertTree(root.left);
//        root.left = invertTree(prevRight);
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }
}