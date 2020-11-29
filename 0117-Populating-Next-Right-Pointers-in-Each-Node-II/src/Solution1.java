import java.util.LinkedList;
import java.util.Queue;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public Node connect(Node root) {
        if (root == null) return null;
        Node cur = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (i < size - 1){
                    cur.next = queue.peek();
                }
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
