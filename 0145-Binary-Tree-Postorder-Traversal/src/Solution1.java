import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution1 {
    //Time Complexity: O(n)
    //Space Complexity： O(h)
    //用栈模拟递归
    //1.访问根节点；2.访问右子树；3.访问左子树；4.逆转（采用链表头插法避免逆转操作）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }

}