import java.util.Arrays;
import java.util.Collections;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}