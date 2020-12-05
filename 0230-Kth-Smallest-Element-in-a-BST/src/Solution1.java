class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count){
            return kthSmallest(root.left, k);
        }else if (k > count + 1){
            return kthSmallest(root.right, k - count - 1);
        }else return root.val;
    }

    private int countNodes(TreeNode root){
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}