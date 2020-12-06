import java.util.Stack;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()){
            q = stack.pop();
            p = stack.pop();
            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (q.val != p.val) return false;
            stack.push(p.right);
            stack.push(q.right);
            stack.push(p.left);
            stack.push(q.left);
        }
        return true;
    }

}