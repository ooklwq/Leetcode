import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {
    //Time Complexity: O(n)
    //Space Complexity: O(h):h is the height of the tree.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;

    }

}