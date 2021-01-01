class Solution {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(n)
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head, slow = head, preSlow = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }
        preSlow.next = null; //左半链表断链
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}