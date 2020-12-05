class Solution1 {

    //Time Complexity:O(m+n)
    //Space Complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//        int m = matrix.length - 1;
//        int n = matrix[0].length - 1;
//        if (target < matrix[0][0] || target > matrix[m][n]) return false;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col <= matrix[0].length - 1){
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                col++;
            else row--;
        }
        return false;

    }
}