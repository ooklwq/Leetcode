import java.util.Stack;

public class Solution {

    //Descending Stack
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int[] dailyTemperatures(int[] T) {
        int[] results = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                results[index] = i - index;
            }
            stack.push(i);
        }
        return results;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] results = new Solution().dailyTemperatures(T);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
