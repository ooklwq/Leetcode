class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i --) {
            int cur = arr[i];
            arr[i] = max;
            max = Math.max(max, cur);
        }
        return arr;
    }
}