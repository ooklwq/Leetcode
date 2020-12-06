class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null || q == null) return false;
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}