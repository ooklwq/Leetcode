import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    //BFS
    //一定要将 queue.size() 放在初始化里，而不能放在判断停止的条件中，
    // 因为q的大小是随时变化的，所以放停止条件中会出错，
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            depth ++ ;
            int levelNum = queue.size();//当前层的节点个数
            for (int i = 0; i < levelNum; i++){
                TreeNode cur = queue.remove();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return depth;
    }


}