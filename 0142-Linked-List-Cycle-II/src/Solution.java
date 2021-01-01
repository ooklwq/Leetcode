public class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //head -> start:x1
    //start-> meet: x2
    //meet -> start:x3
    //fast steps -> x1+x2+x3+x2
    //slow steps -> x1+x2
    //x1+x2+x3+x2 = 2(x1+x2) -> x1=x3
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}