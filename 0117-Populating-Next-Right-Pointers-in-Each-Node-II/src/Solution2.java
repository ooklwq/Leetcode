import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public Node connect(Node root) {
        Node dummy = new Node(0);
        Node cur = dummy, head = root;
        while (root != null) {
            if (root.left != null) {
                cur.next = root.left;
                cur = cur.next;
            }
            if (root.right != null) {
                cur.next = root.right;
                cur = cur.next;
            }
            root = root.next;
            if (root == null) {
                cur = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
        return head;
    }
}
