class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode middleNode(ListNode head) {
        //快慢指针
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5};
        ListNode linkedList1 = new ListNode(nums1);
        System.out.println(new Solution().middleNode(linkedList1).val);//3
        int[] nums2 = new int[]{1,2,3,4,5,6};
        ListNode linkedList2 = new ListNode(nums2);
        System.out.println(new Solution().middleNode(linkedList2).val);//4
    }
}