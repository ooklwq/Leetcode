import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final String[] lettersMap = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;
        letterCombinations(digits, 0, "", res);
        return res;
    }

    private void letterCombinations(String digits, int index, String s, List<String> res){
        if (index == digits.length()){
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = lettersMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinations(digits, index + 1, s + letters.charAt(i), res);
        }
    }


}