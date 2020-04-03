import java.util.ArrayList;
import java.util.List;

class Solution3 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Morris Traversal
//    记当前遍历的节点为 cur。
//  1、cur.left 为 null，保存 cur 的值，更新 cur = cur.right
//  2、cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
//  2.1 last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
//  2.2 last.right 不为 null，说明之前已经访问过，第二次来到这里，表明当前子树遍历完成，保存 cur 的值，更新 cur = cur.right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            //情况 1
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                //找左子树最右边的节点
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                //情况 2.1
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                //情况 2.2
                if (pre.right == cur) {
                    pre.right = null; //这里可以恢复为 null
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }

}