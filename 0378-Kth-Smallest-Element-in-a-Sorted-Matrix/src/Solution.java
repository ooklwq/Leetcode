class Solution {

    //Time Complexity: O(nlogM)
    //Space Complexity: O(1)
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1] + 1;//[left, right)
        while (left < right){
            int mid = left + (right - left) / 2;
            int count = 0, j = n - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j --;
                }
                count += j + 1;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}