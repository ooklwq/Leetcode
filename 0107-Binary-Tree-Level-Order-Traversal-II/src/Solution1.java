import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution1 {

    //up-down -> 头插法
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        DFS(root, 0, res);
        return res;
    }

    private void DFS(TreeNode node, int level, List<List<Integer>> res){
        if (node == null )return;
        if (res.size() == level){
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - 1 - level ).add(node.val);
        DFS(node.left, level + 1, res);
        DFS(node.right, level + 1, res);
    }
}