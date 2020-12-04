import java.util.HashMap;
import java.util.Map;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int fib(int N) {
        if (N < 2) return N;
        int[] fib = new int[N+1];
        fib[1] = 1;
        for (int i = 2; i < N+1; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[N];
    }
}