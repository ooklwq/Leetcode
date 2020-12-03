class Solution1 {

    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode mNode = pre;
        ListNode nNode = pre;
        for (int i = 0; i < m ; i++) {
            pre = mNode;
            mNode = mNode.next;
        }
        for (int i = 0; i < n ; i++) {
            nNode = nNode.next;
        }
        //一直将mNode插入到nNode后
        while (mNode != nNode){
            pre.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            mNode = pre.next;
        }
        return dummyHead.next;
    }
}