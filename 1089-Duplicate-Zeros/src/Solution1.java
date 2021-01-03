class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int zeroCount = 0;
        for (int num : arr) {
            if (num == 0) {
                zeroCount ++;
            }
        }
        int n = arr.length;
        int len = n + zeroCount;
        for (int i = n - 1, j = len - 1; i >= 0 && j >=0; i --, j --) {
            if (arr[i] != 0) {
                if (j < n) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < n) {
                    arr[j] = arr[i];
                }
                j --;
                if (j < n) {
                    arr[j] = arr[i];
                }
            }
        }
    }
}