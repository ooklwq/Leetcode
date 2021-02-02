import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            List<Node> children = cur.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.add(children.get(i));
            }
        }
        return res;
    }

}