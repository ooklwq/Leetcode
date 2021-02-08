import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        postOrder(root, map, res);
        return res;
    }

    private String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + postOrder(root.left, map, res) + "," + postOrder(root.right, map, res);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            res.add(root);
        }
        return serial;
    }
}