class Solution1 {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        long res = num;
        while (res * res > num) {
            res = (res + num / res) / 2;
        }
        return res * res == num;
    }
}