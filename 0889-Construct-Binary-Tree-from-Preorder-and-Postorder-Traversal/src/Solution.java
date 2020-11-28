import java.util.HashMap;
import java.util.Map;

class Solution {

    //Time Complexity: O(n）
    //Space Complexity: O(n)
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || post.length != pre.length)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode helper(int[] pre, int preL, int preR, int[] post, int postL, int postR, Map<Integer, Integer> map){
        if (preL > preR || postL > postR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        if (preL + 1 > preR) return root;
        int leftRootValue = pre[preL + 1];
        int leftRootIndex = map.get(leftRootValue);
        int leftLen = leftRootIndex - postL;
        root.left = helper(pre, preL + 1, preL + 1 + leftLen, post, postL, leftRootIndex, map);
        root.right = helper(pre, preL + 2 + leftLen, preR, post, leftRootIndex + 1, postR - 1, map);
        return root;
    }
}