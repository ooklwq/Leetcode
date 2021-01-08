import java.util.ArrayList;
import java.util.List;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return null;
        }
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                right --;
            } else {
                left ++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}