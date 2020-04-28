import java.util.Arrays;
import java.util.HashSet;

class Solution2 {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(max(m,n))
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int num : nums1){
            if (BinarySearch(num, nums2)) set.add(num);
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set){
            result[k++] = num;
        }
        return result;
    }

    private boolean BinarySearch(int num, int[] nums2){
        int left = 0, right = nums2.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums2[mid] == num) return true;
            else if (nums2[mid] < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

}