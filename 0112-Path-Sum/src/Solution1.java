import java.util.LinkedList;
import java.util.Queue;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    //BFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> curSum = new LinkedList<>();
        queue.offer(root);
        curSum.offer(root.val);
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                int cursum = curSum.poll();
                if (cur.left == null && cur.right == null && cursum == sum)
                    return true;
                if (cur.left != null ){
                    queue.offer(cur.left);
                    curSum.offer(cursum + cur.left.val);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                    curSum.offer(cursum + cur.right.val);
                }
            }
        }
        return false;
    }
}