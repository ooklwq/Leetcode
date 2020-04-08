import java.util.Stack;

class Solution1 {
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()){
            TreeNode[] t = stack.pop();
            if (t[1] == null) continue;//不需要将t2 merge到t1
            t[0].val +=t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            }else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null){
                t[0].right = t[1].right;
            }else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }
}