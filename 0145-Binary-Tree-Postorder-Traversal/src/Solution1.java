import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private List<Integer> postorderTraversal(TreeNode root, List<Integer> list){
        if ( root == null) return list;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
        return list;
    }
}