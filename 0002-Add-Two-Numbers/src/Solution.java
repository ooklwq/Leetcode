class Solution {
    //Time Complexity: O(max(m, n)) m,n分别为l1与l2的长度
    //Space Complexity: O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        ListNode p = l1, q = l2;
        int carry = 0;//进位
        while (p != null || q!= null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            if ( p != null ) p = p.next;
            if ( q != null ) q = q.next;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        ListNode head1 = new ListNode(nums1);
        int[] nums2 = {5, 6, 4};
        ListNode head2 = new ListNode(nums2);
        System.out.println(new Solution().addTwoNumbers(head1, head2));
    }
}