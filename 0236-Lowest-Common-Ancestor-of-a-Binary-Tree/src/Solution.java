class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q)
            return root;
        TreeNode leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
        if ( leftCommonAncestor != null && rightCommonAncestor != null){
            return root;
        }
        return leftCommonAncestor != null ? leftCommonAncestor : rightCommonAncestor;
    }
}