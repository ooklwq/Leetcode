import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution1 {
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public List<Integer> preorderTraversal(TreeNode root) {
        //采用中序遍历的方法，只是将对cur.val的操作改变位置
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }

}