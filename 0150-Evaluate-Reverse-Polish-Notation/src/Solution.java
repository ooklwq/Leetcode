import java.util.Deque;
import java.util.LinkedList;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int left, right;
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left - right);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left / right);
            }  else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}