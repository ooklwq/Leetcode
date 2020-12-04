import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> cache = new HashMap();

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int fib(int N) {
        if (cache.containsKey(N)){
            return cache.get(N);
        }
        int result;
        if (N < 2){
            result = N;
        }else {
            result = fib(N-1)+fib(N-2);
        }
        cache.put(N, result);
        return result;
    }
}