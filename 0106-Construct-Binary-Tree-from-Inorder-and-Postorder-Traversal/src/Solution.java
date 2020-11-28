import java.util.HashMap;
import java.util.Map;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length -1, map);
    }

    private TreeNode helper(int[] inorder, int ileft, int iright, int[] postorder, int pleft, int pright, Map<Integer, Integer> map){
        if (ileft > iright || pleft > pright)
            return null;
        TreeNode root = new TreeNode(postorder[pright]);
        int rootIndex = map.get(root.val);
        root.left = helper(inorder, ileft, rootIndex - 1, postorder, pleft, pleft + rootIndex - ileft - 1, map);
        root.right = helper(inorder, rootIndex + 1, iright, postorder, pleft + rootIndex - ileft, pright - 1, map);
        return root;

    }
}