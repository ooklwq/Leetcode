class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
            }else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = new ListNode(nums);
        System.out.println(head);
        new Solution().removeElements(head, val);
        System.out.println(head);
    }
}