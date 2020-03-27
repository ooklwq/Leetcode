import java.util.Stack;

// Time complexity : O(n)
// Space complexity : O(n)
class Solution2 {
    public boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if( stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isValid("()"));
        System.out.println(new Solution2().isValid("()[]{}"));
        System.out.println(new Solution2().isValid("([)]"));
        System.out.println(new Solution2().isValid("(]"));
        System.out.println(new Solution2().isValid("{[]}"));
    }

}