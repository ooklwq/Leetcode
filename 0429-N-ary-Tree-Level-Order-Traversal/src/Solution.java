import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                level.add(cur.val);
                if (cur.children != null) {
                    for (Node child : cur.children) {
                        queue.add(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}