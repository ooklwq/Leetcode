import java.util.HashMap;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node res = new Node(head.val);
        //old -> new
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node node = res;
        Node cur = head.next;
        hashMap.put(head, res);
        //Create new nodes and maps from old to new.
        while (cur != null){
            Node temp = new Node(cur.val);
            node.next = temp;
            hashMap.put(cur, temp);
            node = node.next;
            cur = cur.next;
        }
        //deal with random
        node = res;
        cur = head;
        while (cur != null){
            node.random = hashMap.get(cur.random);
            node = node.next;
            cur = cur.next;
        }
        return res;
    }

}