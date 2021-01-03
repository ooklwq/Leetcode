class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.next.val == head.val ? head.next : head;
    }
}