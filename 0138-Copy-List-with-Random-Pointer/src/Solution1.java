class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        //copy
        while (cur != null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        //set random
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //restore original and extract res
        cur = head;
        Node res = head.next;
        while (cur != null){
            Node temp = cur.next;
            cur.next = temp.next;
            if (temp.next != null) temp.next = temp.next.next;
            cur = cur.next;
        }
        return res;
    }

}