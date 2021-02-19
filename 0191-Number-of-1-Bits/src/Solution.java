public class Solution {
    // you need to treat n as an unsigned value

    //Time Complexity: O(m)
    //Space Complexity: O(1)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }

}