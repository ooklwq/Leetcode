class Solution1 {

    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode firstNode = pre.next;
            ListNode secondNode = pre.next.next;
            ListNode nextNode = secondNode.next;
            pre.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = nextNode;
            pre = firstNode;
        }
        return dummyHead.next;
    }


}