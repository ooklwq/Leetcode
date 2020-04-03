import java.util.ArrayList;
import java.util.List;

class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(h):h is the height of the tree.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}