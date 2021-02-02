import java.util.HashMap;
import java.util.Map;

class Solution {

    //Time Complexity: O(2^n)
    //Space Complexity: O(n)
    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left, map) + rob(root.left.right, map);
        }
        if (root.right != null) {
            val += rob(root.right.left, map) + rob(root.right.right, map);
        }
        int res = Math.max(val + root.val, rob(root.left, map) + rob(root.right, map));
        map.put(root, res);
        return res;
    }
}