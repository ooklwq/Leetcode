

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(-1);
        ListNode dummyBig = new ListNode(-1);
        ListNode small = dummySmall, big = dummyBig;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = dummyBig.next;
        return dummySmall.next;
    }
}