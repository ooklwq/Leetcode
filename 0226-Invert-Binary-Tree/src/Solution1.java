import java.util.LinkedList;
import java.util.Queue;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return root;
    }
}