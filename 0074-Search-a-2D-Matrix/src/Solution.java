class Solution {

    //Time Complexity: O(log(m*n))
    //Space Complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
//        int[] arr = new int[m*n];
//        //convert 2D to 1D sorted array
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i*n+j] = matrix[i][j];
//            }
//        }
        //binary search
        int left = 0, right = m*n - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (matrix[mid/n][mid%n] == target) return true;
            else if (matrix[mid/n][mid%n] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}