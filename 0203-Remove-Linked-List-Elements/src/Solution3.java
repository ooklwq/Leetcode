class Solution3 {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = new ListNode(nums);
        System.out.println(head);
        new Solution3().removeElements(head, val);
        System.out.println(head);
    }
}