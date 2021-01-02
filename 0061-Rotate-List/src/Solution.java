class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        int len = 0;
        //统计链表长度，并将 fast 指向尾结点
        while (fast.next != null) {
            len ++;
            fast = fast.next;
        }
        //找到第 len - k % len 个结点，将该结点的后一个结点作为新的头结点，并断链
        int slowSteps = len - k % len;
        while (slowSteps > 0) {
            slow = slow.next;
            slowSteps --;
        }
        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;

    }
}