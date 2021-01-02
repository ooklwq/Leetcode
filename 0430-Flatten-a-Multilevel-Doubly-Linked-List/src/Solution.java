class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            if (cur.child == null) {
                cur = cur.next;
                continue;
            }
            Node child = cur.child;
            //找到子链表的tail结点，拼接到cur.next前
            while (child.next != null) {
                child = child.next;
            }
            child.next = cur.next;
            if (cur.next != null) {
                cur.next.prev = child;
            }
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
        }
        return head;
    }
}