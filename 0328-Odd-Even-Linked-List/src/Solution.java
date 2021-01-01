import org.omg.CORBA.FREE_MEM;

import javax.security.auth.login.CredentialException;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, evenHead = head.next, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}