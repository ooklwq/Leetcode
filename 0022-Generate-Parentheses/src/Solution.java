//import java.util.LinkedList;
//import java.util.List;
//
//class Solution {
//
//    //Time Complexity:
//    //Space Complexity:
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new LinkedList<>();
//        if (n <= 0) return res;
//        backtrack(res, n, n, new StringBuilder());
//        return res;
//    }
//
//    private void backtrack(List<String> res, int left, int right, StringBuilder sb){
//        if (left == 0 && right == 0){
//            res.add(sb.toString());
//            return;
//        }
//
//        if (left > 0){
//            sb.append("(");
//            backtrack(res, left - 1, right, sb);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        if (right > left){
//            sb.append(")");
//            backtrack(res, left, right - 1, sb);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//
//    }
//}
import java.util.LinkedList;
import java.util.List;

class Solution {

    //Time Complexity:
    //Space Complexity:
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n <= 0) return res;
        backtrack(res, n, n, "");
        return res;
    }

    private void backtrack(List<String> res, int left, int right, String sb){
        if (left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }

        if (left > 0){
//            sb.append("(");
            backtrack(res, left - 1, right, sb+"(");
//            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left){
//            sb.append(")");
            backtrack(res, left, right - 1, sb+")");
//            sb.deleteCharAt(sb.length() - 1);
        }

    }
}