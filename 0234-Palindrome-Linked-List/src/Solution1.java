import java.util.Stack;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            if (temp.val != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}