import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur = root;
        queue.offer(cur);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}