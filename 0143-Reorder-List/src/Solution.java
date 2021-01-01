class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode mid = findMid(head);
        ListNode l2 = reverseLinkedList(mid);
        ListNode l1 = head;
        merge(l1, l2);
    }

    //找链表的中点
    //slow指向链表中点（若为偶，则为右边那个）
    //将链表划分为两半，slow指向第二个链表的头结点，pre指向第一个链表的尾结点，并将链表断链
    private ListNode findMid(ListNode head){
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
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

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode next1 = l1.next, next2 = l2.next;
            l1.next = l2;
            if (next1 == null) {
                break;
            }
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }
}