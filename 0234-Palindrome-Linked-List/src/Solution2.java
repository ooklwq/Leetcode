class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //奇数链表，慢指针指的中点不用判断
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverseLinkedList(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return pre;
    }
}