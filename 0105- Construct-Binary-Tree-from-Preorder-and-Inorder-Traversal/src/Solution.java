import java.util.HashMap;
import java.util.Map;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright, Map<Integer, Integer> map){
        if (pleft > pright || ileft > iright)
            return null;
        TreeNode root = new TreeNode(preorder[pleft]);
        int rootIndex = map.get(root.val);
        root.left = helper(preorder, pleft + 1, pleft + rootIndex - ileft, inorder, ileft, rootIndex - 1, map);
        root.right = helper(preorder, pleft + rootIndex - ileft + 1, pright, inorder, rootIndex + 1, iright, map);
        return root;
    }
}