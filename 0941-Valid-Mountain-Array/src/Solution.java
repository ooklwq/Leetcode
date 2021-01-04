class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int n = arr.length;
        int start = 0, end = n - 1;
        while (start + 1 < n && arr[start] < arr[start + 1]) {
            start ++;
        }
        while (end > 0 && arr[end] < arr[end - 1]) {
            end --;
        }
        return start != 0 && end != n - 1 && start == end;

    }
}