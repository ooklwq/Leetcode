import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    //up-down -> 头插法
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(0, level);
        }
        return res;
    }
}