class Solution {

    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode next = start.next;
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }
}