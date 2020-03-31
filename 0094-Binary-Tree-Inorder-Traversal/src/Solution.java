import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, null, 2, 3};
        TreeNode root = new TreeNode(nums);
    }
}