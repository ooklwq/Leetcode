public class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = new ListNode(nums, pos);
        System.out.println(new Solution().hasCycle(head));//true
        int[] nums1 = {1, 2};
        int pos1 = 0;
        ListNode head1 = new ListNode(nums1, pos1);
        System.out.println(new Solution().hasCycle(head1));//true
        int[] nums2 = {1};
        int pos2 = -1;
        ListNode head2 = new ListNode(nums2, pos2);
        System.out.println(new Solution().hasCycle(head2));

    }
}