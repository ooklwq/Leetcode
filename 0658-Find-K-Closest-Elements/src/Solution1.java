import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution1 {

    //Time Complexity: O(logn + k)
    //Space Complexity: O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return null;
        }
        int cloestIndex = getCloestIndex(arr, x);
        int left = cloestIndex - 1, right = cloestIndex + 1;
        LinkedList<Integer> res = new LinkedList<>();
        int count = 1;
        res.add(arr[cloestIndex]);
        while (count < k) {
            if (left < 0) {
                res.addLast(arr[right]);
                right ++;
            } else if (right >= arr.length) {
                res.addFirst(arr[left]);
                left --;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                res.addFirst(arr[left]);
                left --;
            }  else {
                res.addLast(arr[right]);
                right ++;
            }
            count ++;
        }
        //最后统一加入结果
//        for (int i = left + 1; i <= right - 1; i++) {
//            res.add(arr[i]);
//        }
        return res;
    }

    private int getCloestIndex(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int cloestIndex = Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
        return cloestIndex;
    }
}