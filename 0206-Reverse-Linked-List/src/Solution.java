class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null ){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(new Solution().reverseList(head));
    }
}