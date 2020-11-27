class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if (left == null || right == null){
            return left == right;
        }
        if (left.val != right.val)
            return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}