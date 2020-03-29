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

    private static ListNode initLinkedList(int[] nums){
        //尾插法建立链表
        ListNode head = new ListNode(nums[0]);
        ListNode tail = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            tail.next = node;
            tail = node;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5};
        ListNode linkedList1 = initLinkedList(nums1);
        System.out.println(new Solution().middleNode(linkedList1).val);//3
        int[] nums2 = new int[]{1,2,3,4,5,6};
        ListNode linkedList2 = initLinkedList(nums2);
        System.out.println(new Solution().middleNode(linkedList2).val);//4
    }
}