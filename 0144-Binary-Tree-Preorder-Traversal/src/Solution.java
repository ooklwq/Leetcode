import java.util.ArrayList;
import java.util.List;

class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private List<Integer> preorderTraversal(TreeNode root, List<Integer> list){
        if (root == null) return list;
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
        return list;
    }
}