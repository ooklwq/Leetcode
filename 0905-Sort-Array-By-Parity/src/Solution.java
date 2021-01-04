class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int n = A.length;
//        for (int i = 0, j = 0; j < n; j++) {
//            if (A[j] % 2 == 0) {
//                swap(A, i++, j);
//            }
//        }
        int i = 0, j = n - 1;
        while (i < j) {
            if (A[i] % 2 == 0) {
                i ++;
            } else {
                if (A[j] % 2 == 1) {//都为奇
                    j --;
                } else {
                    swap(A, i ++, j --);
                }
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}