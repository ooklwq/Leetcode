class Solution1 {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public ListNode middleNode(ListNode head) {
        //遍历链表，将每个数放入新的数组中，记录数值个数size,返回data[size/2]
        ListNode[] data = new ListNode[100];
        int size = 0;
        while (head != null){
            data[size++] = head;
            head = head.next;
        }
        return data[size/2];
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
        System.out.println(new Solution1().middleNode(linkedList1).val);//3
        int[] nums2 = new int[]{1,2,3,4,5,6};
        ListNode linkedList2 = initLinkedList(nums2);
        System.out.println(new Solution1().middleNode(linkedList2).val);//4
    }
}