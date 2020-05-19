public class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = len(headA), lengthB = len(headB);
        while (lengthA > lengthB){
            headA = headA.next;
            lengthA --;
        }
        while (lengthA < lengthB){
            headB = headB.next;
            lengthB --;
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int len(ListNode node){
        int length = 0;
        while (node != null){
            length ++;
            node = node.next;
        }
        return length;
    }
}