class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode cur = head;
        int num = 0;
        while (cur != null) {
            num ++;
            cur = cur.next;
        }
        int[] arr = new int[num];
        cur = head;
        for (int i = 0; i < num; i++, cur = cur.next) {
            arr[i] = cur.val;
        }
        for (int i = 0; i < num / 2; i++) {
            if (arr[i] != arr[num - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}