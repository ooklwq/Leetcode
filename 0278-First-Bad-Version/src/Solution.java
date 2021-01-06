
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//fake class
class VersionControl{
    boolean isBadVersion(int version){return true;}
}
public class Solution extends VersionControl {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public int firstBadVersion(int n) {
        if (n <= 1) {
            return n;
        }
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}