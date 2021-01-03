class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = n - 1; j > i; j --) {
                    arr[j] = arr[j - 1];
                }
                i ++;
            }
        }
    }
}