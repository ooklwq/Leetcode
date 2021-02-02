import java.util.LinkedList;
import java.util.List;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }
}