class Solution {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
//        if (num == 1) {
//            return true;
//        }
//        int left = 1, right = num;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (mid > num / mid) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return (left - 1) * (left - 1) == num;
        int left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = (int)mid - 1;
            } else {
                left = (int)mid + 1;
            }
        }
        return false;
    }
}