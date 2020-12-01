import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>());
        return res;
    }

    private void combine(int n, int k, int start, List<Integer> combine){
        if (combine.size() == k){
            res.add(new ArrayList<>(combine));
            return;
        }
//        for (int i = start; i <= n; i++) {
//            combine.add(i);
//            combine(n, k, i + 1, combine);
//            combine.remove(combine.size() - 1);
//        }
        //剪枝
        //combine还差k-combine.size()   [i,n]至少包含k-combine.size()个元素
        //i最大为 n- (k-combine.size()) + 1
        for (int i = start; i <= n- (k-combine.size()) + 1; i++) {
            combine.add(i);
            combine(n, k, i + 1, combine);
            combine.remove(combine.size() - 1);
        }
    }


}