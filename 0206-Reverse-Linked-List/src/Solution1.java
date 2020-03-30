class Solution1 {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(new Solution1().reverseList(head));
    }
}