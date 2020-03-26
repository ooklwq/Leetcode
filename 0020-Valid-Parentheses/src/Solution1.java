import java.util.HashMap;
import java.util.Stack;

class Solution1 {
    public boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character>  stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)){
                if( stack.isEmpty() || mappings.get(c) != stack.pop()) {
                    return false;
                }
            }else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isValid("()"));
        System.out.println(new Solution1().isValid("()[]{}"));
        System.out.println(new Solution1().isValid("([)]"));
        System.out.println(new Solution1().isValid("(]"));
        System.out.println(new Solution1().isValid("{[]}"));
    }

}