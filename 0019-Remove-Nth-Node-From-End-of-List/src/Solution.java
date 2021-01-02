class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}