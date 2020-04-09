import java.util.Stack;

class Solution {
    //Time Complexity: O(m+n)
    //Space Complexity: O(m+n)
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#'){
                stack.push(c);
            } else if (!stack.isEmpty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        System.out.println(new Solution().backspaceCompare(S, T));
    }
}