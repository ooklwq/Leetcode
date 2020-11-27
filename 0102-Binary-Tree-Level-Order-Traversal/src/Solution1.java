import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution1 {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(root, 0, res);
        return res;
    }

    private void DFS(TreeNode node, int level, List<List<Integer>> res){
        if (node == null) return;
        if (res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        DFS(node.left, level + 1, res);
        DFS(node.right, level + 1, res);
    }
}