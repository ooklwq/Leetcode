class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (true){
            if (p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else return root;
        }

    }
}