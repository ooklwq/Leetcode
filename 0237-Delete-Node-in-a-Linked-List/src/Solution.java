class Solution {
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 9};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode node = head.findNode(5);
        new Solution().deleteNode(node);
        System.out.println(head);
    }
}