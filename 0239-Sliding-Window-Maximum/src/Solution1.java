import java.util.ArrayDeque;
import java.util.Deque;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> max = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (max.peekFirst() == nums[i - k]) {
                    max.pollFirst();
                }
            }
            while (!max.isEmpty() && max.peekLast() < nums[i]) {
                max.pollLast();
            }
            max.offerLast(nums[i]);
            if (i >= k - 1){
                res[i - k + 1] = max.peekFirst();
            }
        }
        return res;
    }
}