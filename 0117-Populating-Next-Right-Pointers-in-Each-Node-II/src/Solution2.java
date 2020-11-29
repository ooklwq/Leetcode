import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public Node connect(Node root) {
        Node dummyHead = new Node(0);
        Node pre = dummyHead, head = root;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
        return head;
    }
}
