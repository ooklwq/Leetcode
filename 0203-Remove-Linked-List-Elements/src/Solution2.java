class Solution2 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = new ListNode(nums);
        System.out.println(head);
        new Solution2().removeElements(head, val);
        System.out.println(head);
    }
}