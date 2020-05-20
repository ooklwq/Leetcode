class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(logn)
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode helper(int[] nums, int low, int high){
        if (low > high) return null;
        int mid = low + (high - low)/ 2;
        //int mid = (low + high) >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}