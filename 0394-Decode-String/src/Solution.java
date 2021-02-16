import java.util.Stack;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                resStack.push(res);
                res = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = res;
                res = resStack.pop();
                for (k = countStack.pop(); k > 0; k --) {
                    res.append(temp);
                }
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}