class Solution1 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = new ListNode(nums);
        System.out.println(head);
        new Solution1().removeElements(head, val);
        System.out.println(head);
    }
}