import java.util.Stack;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(logn)
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<MyNode> stack = new Stack<>();
        TreeNode root = new TreeNode(0);
        stack.push(new MyNode(root, 0, nums.length - 1));
        while (!stack.isEmpty()){
            MyNode cur = stack.pop();
            int mid = cur.low + (cur.high - cur.low)/2;
            cur.node.val = nums[mid];
            if (cur.low <= mid -1){
                cur.node.left = new TreeNode(0);
                stack.push(new MyNode(cur.node.left, cur.low, mid -1));
            }
            if (mid + 1 <= cur.high){
                cur.node.right = new TreeNode(0);
                stack.push(new MyNode(cur.node.right, mid + 1, cur.high));
            }
        }
        return root;
    }

    private class MyNode{
        TreeNode node;
        int low, high;
        public MyNode(TreeNode node, int low, int high){
            this.node = node;
            this.low = low;
            this.high = high;
        }
    }


}