import java.util.ArrayList;
import java.util.List;

class Solution {

    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
//        if (numRows <= 0) return res;
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || i == j){
                    row.add(1);
                }else {
                    int left = res.get(i-1).get(j-1);
                    int right = res.get(i-1).get(j);
                    row.add(left+right);
                }
            }
            res.add(row);
        }
        return res;
    }


}