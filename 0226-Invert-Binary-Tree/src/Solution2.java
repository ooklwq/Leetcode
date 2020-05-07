import java.util.Stack;

class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return root;
    }
}